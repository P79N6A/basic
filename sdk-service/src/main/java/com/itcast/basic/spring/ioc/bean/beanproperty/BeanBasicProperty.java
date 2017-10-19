package com.itcast.basic.spring.ioc.bean.beanproperty;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by treey.qian on 2017/8/30.
 * 静态域的set和get方法必须为非静态方法 否则报错
 */
public class BeanBasicProperty {

    private static long id;
    private BigDecimal amount;
    private String name;
    private Sex sex;
    private Date beginTime;
    private Map map;
    private List list;
    private Set set;
    private Properties properties;

//    public static long getId() {
//        return id;
//    }
//
//    public static void setId(long id) {
//        BeanBasicProperty.id = id;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "BeanBasicProperty{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", beginTime=" + beginTime +
                ", map=" + map +
                ", list=" + list +
                ", set=" + set +
                ", properties=" + properties +
                '}';
    }
}
