package com.itcast.basic.jdk.util.stream;

import java.io.Serializable;

/**
 * Created by qfl on 2018/3/18.
 */
public class Person implements Serializable {
    private String name;
    private int age;
    private long amount;
    private int number;

    public Person(String name, int age, long amount, int number) {
        this.name = name;
        this.age = age;
        this.amount = amount;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof Person) {
            Person person = (Person) obj;
            return person.getName().equals(name);
        }

        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", amount=" + amount +
                '}';
    }
}
