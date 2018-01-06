package com.itcast.basic.spring.dubbo.echoservice.client;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.itcast.basic.spring.dubbo.echoservice.service.UploadService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboEchoServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboEchoServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/echoservice/client/application.xml"});
            EchoService echoService = (EchoService) applicationContext.getBean("uploadService");
            System.out.println(echoService.$echo("ok") + " current is " + System.currentTimeMillis());
            UploadService uploadService = (UploadService) applicationContext.getBean("uploadService");
            uploadService.upload();
            System.out.println("current is " + System.currentTimeMillis());
        } catch (Exception e) {
            System.out.println("DubboEchoServiceClient error message is" + e);
        }
    }
}
