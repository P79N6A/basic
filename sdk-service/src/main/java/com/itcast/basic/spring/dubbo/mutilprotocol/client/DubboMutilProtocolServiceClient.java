package com.itcast.basic.spring.dubbo.mutilprotocol.client;

import com.itcast.basic.spring.dubbo.mutilprotocol.service.SendAudio;
import com.itcast.basic.spring.dubbo.mutilprotocol.service.SendFixbox;
import com.itcast.basic.spring.dubbo.mutilprotocol.service.SendMail;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class DubboMutilProtocolServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboMutilProtocolServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/mutilprotocol/client/application.xml"});
            SendAudio sendAudio = (SendAudio) applicationContext.getBean("sendAudio");
            sendAudio.send();
            SendFixbox sendFixbox = (SendFixbox) applicationContext.getBean("sendFixbox");
            sendFixbox.send();
            SendMail sendMail = (SendMail) applicationContext.getBean("sendMail");
            sendMail.send();
        } catch (Exception e) {
            System.out.println("DubboMutilProtocolServiceClient error is" + e);
        }
    }
}
