package com.itcast.basic.spring.dubbo.cache.client;

import com.itcast.basic.spring.dubbo.cache.service.IncreaseService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboCacheServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboCacheServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/cache/client/application.xml"});
            IncreaseService increaseService = (IncreaseService) applicationContext.getBean("increaseService");
            //LRU的缺省cache.size为1000
            for (int i = 0; i < 5; i++) {
                System.out.println(increaseService.increase("0"));
            }
        } catch (Exception e) {
            System.out.println("DubboCacheServiceClient error message is " + e);
        }
    }
}
