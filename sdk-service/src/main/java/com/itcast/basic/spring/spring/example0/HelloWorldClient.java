package com.itcast.basic.spring.spring.example0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/8/25.
 */
public class HelloWorldClient {

    private static final Log log = LogFactory.getLog(HelloWorldClient.class);

    public static void main(String[] args) {
        try {
            log.info("enter example0.HelloWorldClient");
            HelloWorld helloWorld = new HelloWorld();
            log.info("content is " + helloWorld.getContent());
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
