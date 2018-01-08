package com.itcast.basic.designpatterntype.filter.impl;

import com.itcast.basic.designpatterntype.filter.Person;
import com.itcast.basic.designpatterntype.filter.service.Criteria;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}