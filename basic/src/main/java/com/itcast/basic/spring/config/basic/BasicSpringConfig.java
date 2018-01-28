package com.itcast.basic.spring.config.basic;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by qfl on 16/7/28.
 * 静态域的set和get方法必须为非静态方法 否则报错
 */
public class BasicSpringConfig {

    private static long orderNumber;
    private int id;
    private String name;
    private Date birthday;
    private Sex sex;
    private BigDecimal count;
    private List alias;
    private Map lives;
    private Set cards;
    private Object object;
    private Properties config;

    public BasicSpringConfig() {
    }

    public BasicSpringConfig(int id, String name, Date birthday, Sex sex, long orderNumber, BigDecimal count) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.orderNumber = orderNumber;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

//    public static long getOrderNumber() {
//        return orderNumber;
//    }
//
//    public static void setOrderNumber(long orderNumber) {
//        BasicSpringConfig.orderNumber = orderNumber;
//    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public List getAlias() {
        return alias;
    }

    public void setAlias(List alias) {
        this.alias = alias;
    }

    public Map getLives() {
        return lives;
    }

    public void setLives(Map lives) {
        this.lives = lives;
    }

    public Set getCards() {
        return cards;
    }

    public void setCards(Set cards) {
        this.cards = cards;
    }

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "[id=" + id + " name=" + name + " birthday=" + new SimpleDateFormat("yyyy-MM-dd").format(birthday) + " sex=" + sex + " orderNumber=" + orderNumber + " count=" + count.doubleValue() + "]";
    }
}
