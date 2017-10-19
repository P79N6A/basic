package com.itcast.basic.spring.aop.beforeadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class PersonSave implements SaveService {
    private final Log logger = LogFactory.getLog(PersonSave.class);

    @Override
    public void save() {
        logger.info("begin save person");
    }

}
