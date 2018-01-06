package com.itcast.basic.spring.aop.aspect.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by treey.qian on 2017/10/16.
 */
@Service
public class PersonService {

    private final Log log = LogFactory.getLog(PersonService.class);

    public void createPerson() {
        log.info("create Person");
    }

    public void updatePerson() {
        log.info("update Person");
    }

    public void deletePerson() {
        log.info("delete Person");
    }

    public void findPerson() {
        log.info("find Person");
    }
}
