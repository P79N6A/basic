package com.itcast.basic.spring.spring.example0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/8/25.
 */
public class HelloWorld {

    private final Log log = LogFactory.getLog(HelloWorld.class);

    public String getContent() {
        String content = "";
        try {
            FileHelloStr fileHelloStr = new FileHelloStr("helloworld", "spring/helloWorld.properties");
            content = fileHelloStr.getContent();
        } catch (Exception e) {
            log.info("error is {}", e);
        }
        return content;
    }
}
