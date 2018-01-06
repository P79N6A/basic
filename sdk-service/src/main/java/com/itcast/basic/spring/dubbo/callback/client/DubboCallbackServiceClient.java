package com.itcast.basic.spring.dubbo.callback.client;

import com.itcast.basic.spring.dubbo.callback.service.Callback;
import com.itcast.basic.spring.dubbo.callback.service.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboCallbackServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboCallbackServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/callback/client/application.xml"});
            CallbackService callbackService = (CallbackService) applicationContext.getBean("callbackService");
            callbackService.invoke(new Callback() {
                @Override
                public void callback() {
                    System.out.println("DubboCallbackServiceClient main invoke");
                }
            });
        } catch (Exception e) {
            System.out.println("DubboCallbackServiceClient error message is" + e);
        }
    }
}
