package com.itcast.basic.designpatterntype.builder;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class PersonBuilder implements Builder {

    private Person person;

    public PersonBuilder() {
        person = new Person();
    }


    @Override
    public void buildHead(String head) {
        person.setHead(head);
    }

    @Override
    public void buildBody(String body) {
        person.setBody(body);
    }

    @Override
    public void buildHander(String hander) {
        person.setHander(hander);
    }

    @Override
    public void buildFoot(String foot) {
        person.setFoot(foot);
    }

    @Override
    public Object buildObject() {
        return "Person{" +
                "head='" + person.getHead() + '\'' +
                ", body='" + person.getBody() + '\'' +
                ", hander='" + person.getHander() + '\'' +
                ", foot='" + person.getFoot() + '\'' +
                '}';
    }
}
