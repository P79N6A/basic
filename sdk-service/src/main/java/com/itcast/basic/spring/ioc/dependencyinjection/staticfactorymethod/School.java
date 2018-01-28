package com.itcast.basic.spring.ioc.dependencyinjection.staticfactorymethod;

import com.itcast.basic.spring.ioc.dependencyinjection.Money;

import java.math.BigDecimal;

/**
 * Created by treey.qian on 2017/8/30.
 */
public abstract class School {
    public static Money setSchoolMoney() {
        Money money = new Money();
        money.setBigDecimal(new BigDecimal("125.71"));
        return money;
    }
}
