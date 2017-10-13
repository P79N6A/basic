package com.itcast.basic.spring.aop.aroundadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class PersonFind implements FindService {

    private final Log logger = LogFactory.getLog(PersonFind.class);

    @Override
    public void find() {
        logger.info("query person data");
    }
}
