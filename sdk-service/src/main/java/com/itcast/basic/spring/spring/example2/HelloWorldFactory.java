package com.itcast.basic.spring.spring.example2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/8/25.
 */
public class HelloWorldFactory {
    private static final Log log = LogFactory.getLog(HelloWorldFactory.class);

    public static HelloWorld createHelloWorld(String key, String fileName) {
        HelloWorld helloWorld = null;
        try {
            FileHelloStr fileHelloStr = new FileHelloStr(key, fileName);
            helloWorld = new HelloWorld(fileHelloStr);
        } catch (Exception e) {
            log.info("error is {}", e);
        }
        return helloWorld;
    }
}
