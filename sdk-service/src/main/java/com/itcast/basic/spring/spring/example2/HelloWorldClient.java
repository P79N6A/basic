package com.itcast.basic.spring.spring.example2;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/8/25.
 */
public class HelloWorldClient {

    private static final Log log = LogFactory.getLog(HelloWorldClient.class);

    public static void main(String[] args) {
        try {
            log.info("enter example1.HelloWorldClient");
            HelloWorld helloWorld = HelloWorldFactory.createHelloWorld("helloworld1", "spring/helloWorld.properties");
            log.info("content is " + helloWorld.getContent());
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
