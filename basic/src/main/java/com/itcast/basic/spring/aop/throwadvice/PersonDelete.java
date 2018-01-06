package com.itcast.basic.spring.aop.throwadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class PersonDelete implements DeleteService {
    private final Log logger = LogFactory.getLog(PersonDelete.class);

    @Override
    public void delete() {
        logger.info("begin delete person");
        int i = 10 / 0;
    }
}
