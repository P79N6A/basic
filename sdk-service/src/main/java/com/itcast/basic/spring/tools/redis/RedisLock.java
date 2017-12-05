package com.itcast.basic.spring.tools.redis;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by treey.qian on 2017/10/23.
 */
public class RedisLock {

    /**
     * 延迟时间
     */
    private final long DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 10 * 1000;

    /**
     * 锁超时时间，防止线程在入锁以后，无限的执行等待
     */
    private long lockTimeValue = 60 * 1000;

    /**
     * 锁等待时间，防止线程饥饿
     */
    private long timeoutMsecs = 60 * 100 * 1000;

    private volatile boolean locked = false;

    private static RedisTemplate redisTemplate;
    private static String lockKey;

    public RedisLock(RedisTemplate redisTemplate, String lockKey) {
        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey;
    }

    public RedisLock(RedisTemplate redisTemplate, String lockKey, long lockTimeValue) {
        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey;
        this.lockTimeValue = lockTimeValue;
        this.timeoutMsecs = (lockTimeValue > timeoutMsecs ? lockTimeValue : timeoutMsecs);
    }

    //多线程获取不同时间戳
    private Long currentTimeMillis() {
        return redisTemplate.getConnectionFactory().getConnection().time();
    }

    public synchronized boolean lockWithExpire() throws InterruptedException {
        long timeout = timeoutMsecs;
        while (timeout >= 0) {
            String expiresValue = new StringBuilder().append(currentTimeMillis() + lockTimeValue).toString();
            if (redisTemplate.opsForValue().setIfAbsent(lockKey, expiresValue)) {
                locked = true;
                return true;
            }
            Object expiresValueObject = redisTemplate.opsForValue().get(lockKey);
            if (expiresValueObject != null && Long.parseLong(expiresValueObject.toString()) < currentTimeMillis()) {
                expiresValue = new StringBuilder().append(currentTimeMillis() + lockTimeValue).toString();
                Object oldexpiresValue = redisTemplate.opsForValue().getAndSet(lockKey, expiresValue);
                if (oldexpiresValue != null && oldexpiresValue.toString().equals(expiresValueObject.toString())) {
                    locked = true;
                    return true;
                }
            }
            timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
            /*
                延迟100 毫秒,  这里使用随机时间可能会好一点,可以防止饥饿进程的出现,即,当同时到达多个进程,
                只会有一个进程获得锁,其他的都用同样的频率进行尝试,后面有来了一些进行,也以同样的频率申请锁,这将可能导致前面来的锁得不到满足.
                使用随机的等待时间可以一定程度上保证公平性
             */
            Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
        }
        return false;
    }

    public synchronized boolean lock() {
        while (!locked) {
            String lockValue = currentTimeMillis().toString();
            // redis为单进程单线程模型 redisTemplate.opsForValue().setIfAbsent(lockKey, lockValue) 不存在并发问题
            if (redisTemplate.opsForValue().setIfAbsent(lockKey, lockValue)) {
                locked = true;
            }
            //redis为单进程单线程模型 redisTemplate.opsForValue().get(lockKey) 不存在并发问题
            Object lockValueObject = redisTemplate.opsForValue().get(lockKey);
            //判断锁是否过期
            //多节点存在同时满足lockValueObject != null && Long.parseLong(lockValueObject.toString()) < currentTimeMillis() 条件进入if代码块
            if (lockValueObject != null && Long.parseLong(lockValueObject.toString()) < currentTimeMillis()) {
                lockValue = currentTimeMillis().toString();
                Object oldValueObject = redisTemplate.opsForValue().getAndSet(lockKey, lockValue);
                //判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
                if (oldValueObject != null && oldValueObject.toString().equals(lockValueObject.toString())) {
                    locked = true;
                }
            }
        }
        return locked;
    }

    public synchronized void unlock() {
        if (locked) {
            redisTemplate.delete(lockKey);
            locked = false;
        }
    }
}
