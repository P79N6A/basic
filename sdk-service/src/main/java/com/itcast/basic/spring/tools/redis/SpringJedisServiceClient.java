package com.itcast.basic.spring.tools.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;

/**
 * Created by treey.qian on 2017/10/20.
 */
public class SpringJedisServiceClient {
    private static final Log logger = LogFactory.getLog(SpringJedisServiceClient.class);
    private static RedisTemplate redisTemplate;

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringJedisServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/redis/application.xml"});
            redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
            redisTemplate.opsForValue().set("name", "qfl");
//            transaction();
//            concurrent();
//            lock();
        } catch (Exception e) {
            logger.info("SpringJedisServiceClient error message is {}", e);
            e.printStackTrace();
        }
    }

    private static void lock() {
        RedisLock redisLock = new RedisLock(redisTemplate, "lock", 20000);
        try {
            if (redisLock.lock()) {
                logger.info("get a redis lock");
            } else {
                logger.info("get no redis lock");
            }
        } catch (Exception e) {
            logger.info("get   redis lock error message is {}", e);
        } finally {
            redisLock.unlock();
        }

    }

    private static void concurrent() throws IOException {
        redisTemplate.opsForValue().set("num", 0);
        Thread t1 = new Thread(new Job());
        t1.start();

        Thread t2 = new Thread(new Job());
        t2.start();

        System.in.read();
    }

    private static class Job implements Runnable {

        @Override
        public void run() {
//            synchronized (Job.class) {
            for (int i = 0; i < 2000; i++) {
//                redisTemplate.opsForValue().set("num", i);
//                System.out.println(Thread.currentThread().getId() + "线程结束，输出num=" + redisTemplate.opsForValue().get("num"));
                System.out.println(Thread.currentThread().getId() + "线程结束，输出num=" + redisTemplate.opsForValue().increment("num", 1));
            }
//            }
//            System.out.println("线程结束，输出num=" + redisTemplate.opsForValue().get("num"));
        }
    }

    private static void transaction() {
        //监听键值
        redisTemplate.watch("name");
        //开启事务
        redisTemplate.multi();
        //业务操作
        redisTemplate.opsForValue().set("name", "treey");
        //提交事务
        redisTemplate.exec();
    }
}
