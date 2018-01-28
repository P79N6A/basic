package com.itcast.basic.spring.annatation.aop;

import org.springframework.stereotype.Service;

/**
 * Created by qfl on 16/7/31.
 */
@Service
public class SaveService {

    public void sysHello(String name) {
        System.out.println("hello world, i am "+name);
    }

    public void savePerson() {
        System.out.println("保存对象");
    }
}
