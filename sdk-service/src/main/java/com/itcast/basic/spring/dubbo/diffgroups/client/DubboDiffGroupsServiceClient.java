package com.itcast.basic.spring.dubbo.diffgroups.client;

import com.itcast.basic.spring.dubbo.diffgroups.service.InstructionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class DubboDiffGroupsServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboDiffGroupsServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/diffgroups/client/application.xml"});
            InstructionService beifuInstructionService = (InstructionService) applicationContext.getBean("beifuInstructionService");
            beifuInstructionService.invoke();
            InstructionService ebaInstructionService = (InstructionService) applicationContext.getBean("ebaInstructionService");
            ebaInstructionService.invoke();
        } catch (Exception e) {
            System.out.println("DubboDiffGroupsServiceClient error is " + e);
        }
    }
}
