package com.itcast.basic.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qfl on 16/6/10.
 */
@Entity
@Table(name = "t_orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 123456789l;

    @Id
    @GeneratedValue
    private Integer id;

    private long number;

    private String name;

    private BigDecimal price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createAt=" + createAt +
                ", user=" + user +
                '}';
    }
}
