package com.itcast.basic.spring.timer.timertask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Timer;

/**
 * Created by treey.qian on 2017/10/26.
 */
public class JobTaskServiceClient {
    private static final Log logger = LogFactory.getLog(JobTaskServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into JobTaskServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/timer/timertask/application.xml"});
            final Timer timerFactoryBean = (Timer) applicationContext.getBean("timerFactoryBean");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                        timerFactoryBean.cancel();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            synchronized (logger) {
                logger.wait();
            }
        } catch (Exception e) {
            logger.info("JobTaskServiceClient error message is {}", e);
        }
    }


}
