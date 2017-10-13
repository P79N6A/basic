package com.itcast.basic.spring.aop.afteradvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class PersonUpdate implements UpdateService {
    private final Log logger = LogFactory.getLog(PersonUpdate.class);

    @Override
    public void update() {
        logger.info("begin update person");
    }
}
