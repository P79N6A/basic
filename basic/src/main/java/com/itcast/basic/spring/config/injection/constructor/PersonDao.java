package com.itcast.basic.spring.config.injection.constructor;

import com.itcast.basic.spring.config.injection.PersonService;

/**
 * Created by qfl on 16/7/28.
 */
public class PersonDao {

    private PersonService personService;

    public PersonDao() {
    }

    public PersonDao(PersonService service) {
        this.personService = service;
    }

    public PersonService getPersonService() {
        return personService;
    }
}
