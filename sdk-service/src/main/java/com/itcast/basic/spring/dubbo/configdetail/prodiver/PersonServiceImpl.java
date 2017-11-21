package com.itcast.basic.spring.dubbo.configdetail.prodiver;

import com.itcast.basic.spring.dubbo.configdetail.service.SaveService;

/**
 * Created by treey.qian on 2017/11/13.
 */
public class PersonServiceImpl implements SaveService {
    @Override
    public void sysHello() {
        System.out.println("PersonServiceImpl save");
    }
}
