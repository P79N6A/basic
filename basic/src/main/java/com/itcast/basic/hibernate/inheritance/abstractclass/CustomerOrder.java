package com.itcast.basic.hibernate.inheritance.abstractclass;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qfl on 16/7/8.
 */
public class CustomerOrder extends Order {
    private Date expendAt;

    public CustomerOrder(String name, User user, int count, BigDecimal price, Date expendAt) {
        super(name, user, count, price);
        this.expendAt = expendAt;
    }

    public CustomerOrder(Date expendAt) {
        this.expendAt = expendAt;
    }

    public Date getExpendAt() {
        return expendAt;
    }

    public void setExpendAt(Date expendAt) {
        this.expendAt = expendAt;
    }
}
