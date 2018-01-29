package com.itcast.basic.test.qfl.client;

/**
 * Created by treey.qian on 2017/7/21.
 */
public class Person {

    private int id;

    private String name;

    private char sex;

    private int age;

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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(EventSource source) {
        System.out.println("enter not param Person");
        source.registerListener(new EventListener() {
            public void onEvent() {
                doSomething();
            }
        });
    }

    public Person(int id, String name, char sex, int age) {
        System.out.println("enter  params Person");
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    void doSomething() {
        System.out.println("enter doSomething Person");
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
