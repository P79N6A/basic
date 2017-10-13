package com.itcast.basic.spring.aop.instroductionadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class PersonMessage implements MessageService {

    private final Log log = LogFactory.getLog(PersonMessage.class);

    @Override
    public void sendEmailMessage() {
        log.info("sendEmailMessage");
    }

    @Override
    public void sendPhoneMessage() {
        log.info("sendPhoneMessage");
    }

    @Override
    public void sendWeChatMessage() {
        log.info("sendWeChatMessage");
    }
}
