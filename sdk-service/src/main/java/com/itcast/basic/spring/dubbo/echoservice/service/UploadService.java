package com.itcast.basic.spring.dubbo.echoservice.service;

import com.alibaba.dubbo.rpc.service.EchoService;

/**
 * Created by treey.qian on 2017/11/23.
 */
public interface UploadService extends EchoService {
    boolean upload();
}
