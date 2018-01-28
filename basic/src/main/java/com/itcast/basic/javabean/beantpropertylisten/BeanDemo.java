package com.itcast.basic.javabean.beantpropertylisten;

/**
 * Created by qfl on 16/5/10.
 */
public class BeanDemo {
    public static void main(String[] args) {
        Person person = new Person();
        BeanPropertyListener listener = new BeanPropertyListener();
        person.addPropertyChangeListener(listener);
        person.addVetoableChangeListener(listener);
        person.setName("Lily");
        person.setName(null);
    }
}
