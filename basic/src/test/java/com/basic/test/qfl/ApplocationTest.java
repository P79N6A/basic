package com.basic.test.qfl;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ApplocationTest {

    @Test
    public void testMethod() {
        try {
            Person person = new Person();
            mody(person);
            System.out.println("person=" + person);
            String text = "hello";
            mody(text);
            System.out.println("text=" + text);
            int i = 90;
            mody(i);
            System.out.println("i=" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mody(Integer i) {

    }

    private void mody(String text) {
        //  text = text + " world";
//          text = new StringBuilder(text).append(" world").toString();
//        text += " world";
//        text="sss";
        text.toUpperCase();
    }


    private void mody(Person person) {
//        person.setName("admin");
        person = new Person(2, "root");
    }


    class Person {
        private int id;
        private String name;

        public Person() {

        }

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
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

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
                   
}
