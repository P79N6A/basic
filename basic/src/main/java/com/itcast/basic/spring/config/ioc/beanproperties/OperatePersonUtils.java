package com.itcast.basic.spring.config.ioc.beanproperties;

import java.util.Date;

/**
 * Created by qfl on 16/7/28.
 */
public class OperatePersonUtils {

    private String operateName;
    private Date birthday;

    private Person person;

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
