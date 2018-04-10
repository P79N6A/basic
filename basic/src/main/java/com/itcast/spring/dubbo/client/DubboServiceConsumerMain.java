package com.itcast.spring.dubbo.client;

import com.itcast.spring.dubbo.service.FtpService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Created by treey.qian on 2017/11/13.
 */
public class DubboServiceConsumerMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboServiceConsumerMain");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/client/application.xml"});
            FtpService ftpService= (FtpService) applicationContext.getBean("ftpService");
            ftpService.open();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            countDownLatch.await();
        } catch (Exception e) {
            System.out.println("error message is {}" + e);
        }
    }
}
