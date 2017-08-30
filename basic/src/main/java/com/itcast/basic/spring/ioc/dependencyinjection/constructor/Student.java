package com.itcast.basic.spring.ioc.dependencyinjection.constructor;

import com.itcast.basic.spring.ioc.dependencyinjection.Money;

/**
 * Created by treey.qian on 2017/8/30.
 */
public class Student {
    private Money money;

    public Student() {
    }

    public Student(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Student{" +
                "money=" + money +
                '}';
    }
}
