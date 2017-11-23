package com.itcast.basic.spring.dubbo.mergegroups.client;

import com.itcast.basic.spring.dubbo.mergegroups.dto.RequestDto;
import com.itcast.basic.spring.dubbo.mergegroups.dto.ResponseDto;
import com.itcast.basic.spring.dubbo.mergegroups.service.StoppaymentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class DubboMutilMergeServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboMutilMergeServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/mergegroups/client/application.xml"});
            StoppaymentService stoppaymentService = (StoppaymentService) applicationContext.getBean("stoppaymentService");
            RequestDto requestDto = new RequestDto();
            requestDto.setType("beifu");
            ResponseDto responseDto = stoppaymentService.stop(requestDto);
            System.out.println("responseDto=" + responseDto);
        } catch (Exception e) {
            System.out.println("DubboMutilMergeServiceClient error is " + e);
        }
    }
}
