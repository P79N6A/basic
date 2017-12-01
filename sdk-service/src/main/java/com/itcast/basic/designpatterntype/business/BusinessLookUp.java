package com.itcast.basic.designpatterntype.business;

import com.itcast.basic.designpatterntype.business.impl.EJBService;
import com.itcast.basic.designpatterntype.business.impl.JMSService;
import com.itcast.basic.designpatterntype.business.service.BusinessService;

public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType) {
        if (serviceType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}