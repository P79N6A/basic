package com.itcast.basic.spring.dubbo.mergegroups.service;

import com.itcast.basic.spring.dubbo.mergegroups.dto.RequestDto;
import com.itcast.basic.spring.dubbo.mergegroups.dto.ResponseDto;

/**
 * Created by treey.qian on 2017/11/22.
 */
public interface StoppaymentService {
    ResponseDto stop(RequestDto requestDto);
}
