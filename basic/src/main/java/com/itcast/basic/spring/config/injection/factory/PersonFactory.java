package com.itcast.basic.spring.config.injection.factory;

import com.itcast.basic.spring.config.injection.PersonService;

/**
 * Created by qfl on 16/7/28.
 */
public class PersonFactory {
    public  PersonService createPersonService() {
        return new PersonService();
    }
}
