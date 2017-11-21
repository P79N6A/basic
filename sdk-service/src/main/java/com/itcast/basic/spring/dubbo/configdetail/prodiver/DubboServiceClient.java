package com.itcast.basic.spring.dubbo.configdetail.prodiver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/13.
 */
public class DubboServiceClient {
//    private final static Log logger = LogFactory.getLog(DubboServiceClient.class);

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboServiceClient");
            new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/configdetail/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
//            logger.info("error message is {}", e);
            System.out.println("error message is " + e);
        }
    }
}
