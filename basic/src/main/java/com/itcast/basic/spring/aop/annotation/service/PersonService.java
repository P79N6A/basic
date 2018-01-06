package com.itcast.basic.spring.aop.annotation.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by treey.qian on 2017/10/16.
 */
@Service
public class PersonService {

    private final Log log = LogFactory.getLog(PersonService.class);

    public void savePerson(String name) {
        log.info("save person,person name is " + name);
    }


}
