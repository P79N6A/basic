package com.itcast.basic.javabean.reflecttype;

import com.itcast.basic.javabean.annotationtype.BeanModel;

/**
 * Created by qfl on 16/4/22.
 */
@BeanModel(name = "PersonClass")
public class Person {

    private int id;
    public String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @BeanModel(name = "setId", value = "id", UUID = 123456)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
