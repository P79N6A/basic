package com.itcast.basic.hibernate.inheritance.abstractclass;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qfl on 16/7/8.
 */
public class ProductOrder extends Order {
    private Date createAt;

    public ProductOrder() {
    }

    public ProductOrder(String name, User user, int count, BigDecimal price, Date createAt) {
        super(name, user, count, price);
        this.createAt = createAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
