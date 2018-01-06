package com.itcast.basic.spring.dubbo.mergegroups.impl;

import com.itcast.basic.spring.dubbo.mergegroups.dto.RequestDto;
import com.itcast.basic.spring.dubbo.mergegroups.dto.ResponseDto;
import com.itcast.basic.spring.dubbo.mergegroups.service.StoppaymentService;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class EbaStoppaymentServiceImpl implements StoppaymentService {

    @Override
    public ResponseDto stop(RequestDto requestDto) {
        System.out.println("EbaStoppaymentServiceImpl stop invoke");
        ResponseDto responseDto = new ResponseDto();
        if (requestDto != null && "eba".equals(requestDto.getType())) {
            responseDto.setCode("200");
            responseDto.setMessage("success");
            responseDto.setSystemId("eba");
        } else {
            responseDto.setCode("200");
            responseDto.setMessage("不需要处理");
            responseDto.setSystemId("eba");
        }
        return responseDto;
    }
}
