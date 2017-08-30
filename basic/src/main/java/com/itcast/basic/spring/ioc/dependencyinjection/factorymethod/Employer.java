package com.itcast.basic.spring.ioc.dependencyinjection.factorymethod;

import com.itcast.basic.spring.ioc.dependencyinjection.Money;

import java.math.BigDecimal;

/**
 * Created by treey.qian on 2017/8/30.
 */
public class Employer {

    public Money setEmployerMoney() {
        Money money = new Money();
        money.setBigDecimal(new BigDecimal("125.72"));
        return money;
    }
}
