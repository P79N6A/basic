package com.itcast.basic.spring.config.injection.factory;

import com.itcast.basic.spring.config.injection.PersonService;

/**
 * Created by qfl on 16/7/28.
 */
public class PersonDao {

    private PersonService personService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public PersonService getPersonService() {
        return personService;
    }
}
