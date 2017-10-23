package com.itcast.basic.spring.tools.redis;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by treey.qian on 2017/10/23.
 */
public class RedisLock {
    private RedisTemplate redisTemplate;
    private String lockKey;
    private volatile boolean locked = false;
    private final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;
    /**
     * 锁超时时间，防止线程在入锁以后，无限的执行等待
     */
    private long lockTimeValue = 60 * 1000;

    /**
     * 锁等待时间，防止线程饥饿
     */
    private int timeoutMsecs = 10 * 1000;

    public RedisLock(RedisTemplate redisTemplate, String lockKey, long lockTimeValue) {
        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey;
        this.lockTimeValue = lockTimeValue;
    }

    public RedisLock(RedisTemplate redisTemplate, String lockKey, long lockTimeValue, int timeoutMsecs) {
        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey;
        this.lockTimeValue = lockTimeValue;
        this.timeoutMsecs = timeoutMsecs;
    }

    public RedisLock() {
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String getLockKey() {
        return lockKey;
    }

    public void setLockKey(String lockKey) {
        this.lockKey = lockKey;
    }

    public long getLockTimeValue() {
        return lockTimeValue;
    }

    public void setLockTimeValue(long lockTimeValue) {
        this.lockTimeValue = lockTimeValue;
    }

    public synchronized boolean lock() throws InterruptedException {
        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            String expiresStr = System.currentTimeMillis() + lockTimeValue + 1 + "";
            if (redisTemplate.opsForValue().setIfAbsent(lockKey, expiresStr)) {
                // redis为单进程单线程模型 此处不存在并发问题
                locked = true;
                return true;
            }

            Object currentValueStr = redisTemplate.opsForValue().get(lockKey); //redis为单进程单线程模型 此处不存在并发问题
            if (currentValueStr != null && Long.parseLong(currentValueStr.toString()) < System.currentTimeMillis()) {//会存在多个线程满足次条件进入if代码块
                //判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
                expiresStr = System.currentTimeMillis() + lockTimeValue + 1 + "";
                Object oldValueStr = redisTemplate.opsForValue().getAndSet(lockKey, expiresStr);//redis为单进程单线程模型 此处不存在并发问题 若2个线程同时到达此处 则2个线程设置的
                //获取上一个锁到期时间，并设置现在的锁到期时间，
                if (oldValueStr != null && oldValueStr.equals(currentValueStr.toString())) {
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

    public synchronized void unlock() {
        if (locked) {
            redisTemplate.delete(lockKey);
            locked = false;
        }
    }
}
