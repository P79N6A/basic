package com.itcast.basic.designpatterntype.chain;

import com.itcast.basic.designpatterntype.chain.impl.ConsoleLogger;
import com.itcast.basic.designpatterntype.chain.impl.ErrorLogger;
import com.itcast.basic.designpatterntype.chain.impl.FileLogger;
import com.itcast.basic.designpatterntype.chain.service.AbstractLogger;

public class ChainServiceClient {

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        try {
            AbstractLogger loggerChain = getChainOfLoggers();

            loggerChain.logMessage(AbstractLogger.INFO,
                    "This is an information.");

            loggerChain.logMessage(AbstractLogger.DEBUG,
                    "This is an debug level information.");

            loggerChain.logMessage(AbstractLogger.ERROR,
                    "This is an error information.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}