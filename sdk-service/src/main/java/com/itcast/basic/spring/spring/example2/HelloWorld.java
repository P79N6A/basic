package com.itcast.basic.spring.spring.example2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/8/25.
 */
public class HelloWorld {
    private final Log log = LogFactory.getLog(HelloWorld.class);

    private HelloStr helloStr;

    public HelloWorld(HelloStr helloStr) {
        this.helloStr = helloStr;
    }

    public String getContent() {
        return helloStr.getContent();
    }
}
