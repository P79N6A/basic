package com.itcast.basic.designpatterntype.filter.service;

import com.itcast.basic.designpatterntype.filter.Person;

import java.util.List;

public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}