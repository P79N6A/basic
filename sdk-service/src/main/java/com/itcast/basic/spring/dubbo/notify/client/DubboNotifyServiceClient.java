package com.itcast.basic.spring.dubbo.notify.client;

import com.itcast.basic.spring.dubbo.notify.service.NotifyService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboNotifyServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboNotifyServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/notify/client/application.xml"});
            NotifyService notifyService = (NotifyService) applicationContext.getBean("notifyService");
            notifyService.notify(500);
        } catch (Exception e) {
            System.out.println("DubboNotifyServiceClient error message is" + e);
        }
    }
}
