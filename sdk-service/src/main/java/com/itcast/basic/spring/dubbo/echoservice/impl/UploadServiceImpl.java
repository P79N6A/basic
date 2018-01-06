package com.itcast.basic.spring.dubbo.echoservice.impl;

import com.itcast.basic.spring.dubbo.echoservice.service.UploadService;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class UploadServiceImpl implements UploadService {
    @Override
    public Object $echo(Object message) {
        return "service is heath,you enter into text is " + message;
    }

    @Override
    public boolean upload() {
        boolean isSuccess = false;
        try {
            System.out.println("upload...." + " current is " + System.currentTimeMillis());
            Thread.sleep(500);
            isSuccess = true;
        } catch (Exception e) {
            System.out.println("UploadServiceImpl error message is" + e);
        }
        return isSuccess;
    }
}
