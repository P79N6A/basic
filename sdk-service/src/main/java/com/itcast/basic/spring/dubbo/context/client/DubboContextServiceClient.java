package com.itcast.basic.spring.dubbo.context.client;

import com.alibaba.dubbo.rpc.RpcContext;
import com.itcast.basic.spring.dubbo.context.service.DownloadService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboContextServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboContextServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/context/client/application.xml"});
            DownloadService downloadService = (DownloadService) applicationContext.getBean("downloadService");
            System.out.println("result is " + downloadService.download());
            StringBuilder dubboInfo = new StringBuilder();
            dubboInfo.append("isConsumerSide is ")
                    .append(RpcContext.getContext().isConsumerSide())
                    .append(" remote host is ")
                    .append(RpcContext.getContext().getRemoteHost())
                    .append(" application is ")
                    .append(RpcContext.getContext().getUrl().getParameter("application"));
            System.out.println("dubbo info is " + dubboInfo.toString());
        } catch (Exception e) {
            System.out.println("DubboContextServiceClient error message is" + e);
        }
    }
}
