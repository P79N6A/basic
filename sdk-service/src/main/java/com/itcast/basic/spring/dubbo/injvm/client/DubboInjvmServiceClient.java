package com.itcast.basic.spring.dubbo.injvm.client;

import com.itcast.basic.spring.dubbo.injvm.service.InjvmCallback;
import com.itcast.basic.spring.dubbo.injvm.service.InjvmService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboInjvmServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboInjvmServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/injvm/client/application.xml"});
            InjvmService injvmService = (InjvmService) applicationContext.getBean("injvmService");
            injvmService.callback("DubboInjvmServiceClient main");
        } catch (Exception e) {
            System.out.println("DubboInjvmServiceClient error message is" + e);
        }
    }
}
