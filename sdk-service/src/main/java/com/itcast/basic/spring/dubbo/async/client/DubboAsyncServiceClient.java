package com.itcast.basic.spring.dubbo.async.client;

import com.alibaba.dubbo.rpc.RpcContext;
import com.itcast.basic.spring.dubbo.async.service.AsyncService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Future;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboAsyncServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboAsyncServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/async/client/application.xml"});
            AsyncService asyncService = (AsyncService) applicationContext.getBean("asyncService");
            String result = asyncService.async();
            System.out.println("result is " + result);
            Future<String> future = RpcContext.getContext().getFuture();
            System.out.println("result is " + future.get());

        } catch (Exception e) {
            System.out.println("DubboAsyncServiceClient error message is" + e);
        }
    }
}
