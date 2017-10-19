package com.itcast.basic.spring.ioc.dependencyinjection.injector;

import com.itcast.basic.spring.ioc.dependencyinjection.Money;

/**
 * Created by treey.qian on 2017/8/30.
 */
public class Teacher {
   private Money money;

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "money=" + money +
                '}';
    }
}
