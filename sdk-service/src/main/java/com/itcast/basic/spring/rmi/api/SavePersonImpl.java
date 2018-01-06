package com.itcast.basic.spring.rmi.api;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/10/30.
 */
public class SavePersonImpl implements SavePerson {

    private final Log log = LogFactory.getLog(SavePersonImpl.class);

    @Override
    public void save(Person person) {
        log.info("person is " + person);
    }
}
