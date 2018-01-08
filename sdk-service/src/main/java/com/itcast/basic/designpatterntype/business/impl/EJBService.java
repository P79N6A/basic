package com.itcast.basic.designpatterntype.business.impl;

import com.itcast.basic.designpatterntype.business.service.BusinessService;

public class EJBService implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}