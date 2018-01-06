package com.itcast.basic.designpatterntype.chain.impl;

import com.itcast.basic.designpatterntype.chain.service.AbstractLogger;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}