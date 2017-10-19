package com.itcast.basic.spring.ioc.dependencyinjection;

import java.math.BigDecimal;

/**
 * Created by treey.qian on 2017/8/30.
 */
public class Money {

    private BigDecimal bigDecimal;

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    @Override
    public String toString() {
        return "Money{" +
                "bigDecimal=" + bigDecimal +
                '}';
    }
}
