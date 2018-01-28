package com.itcast.basic.hibernate.hibernatebasicconfig.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qfl on 16/7/6.
 */
public class User implements Serializable {
    private static final long serivalVersionUID = 123456789l;

    private int id;
    private String number;
    private BigDecimal deposit;
    private Date birthday;
    private Sex sex;
    private Status status;

    private int version;

    private Name name;
    private Address address;

    public User(int id, String number, Name name, Status status, Date birthday, Sex sex, BigDecimal deposit, Address address) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.status = status;
        this.birthday = birthday;
        this.sex = sex;
        this.deposit = deposit;
        this.address = address;
    }

    public User() {
    }

    public static long getSerivalVersionUID() {
        return serivalVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
