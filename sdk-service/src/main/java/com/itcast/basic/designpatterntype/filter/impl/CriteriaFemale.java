package com.itcast.basic.designpatterntype.filter.impl;

import com.itcast.basic.designpatterntype.filter.Person;
import com.itcast.basic.designpatterntype.filter.service.Criteria;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}