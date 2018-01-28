package com.itcast.basic.designpatterntype.memorandum;

/**
 * Created by qfl on 16/6/4.
 */
public class Subject {
    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Memora createMemora() {
        return new Memora(name);
    }

    public void restoreMemora(Memora memora) {
        this.name = memora.getName();
    }
}
