package com.itcast.basic.spring.spring.example3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/8/25.
 */
public class HelloWorld {
    private final Log log = LogFactory.getLog(HelloWorld.class);

    private FileHelloStr fileHelloStr;

    public HelloWorld(FileHelloStr fileHelloStr) {
        this.fileHelloStr = fileHelloStr;
    }

    public String getContent() {
        return fileHelloStr.getContent();
    }
}
