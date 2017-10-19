package com.itcast.basic.spring.aop.aspect.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by treey.qian on 2017/10/16.
 */
@Service
public class MessageService {

    private final Log log = LogFactory.getLog(MessageService.class);

    public void createMessage() {
        log.info("create Message");
    }

    public void updateMessage() {
        log.info("update Message");
    }

    public void deleteMessage() {
        log.info("delete Message");
    }

    public void findMessage() {
        log.info("find Message");
    }
}
