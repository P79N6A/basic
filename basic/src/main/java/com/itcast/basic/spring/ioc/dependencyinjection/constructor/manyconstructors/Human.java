package com.itcast.basic.spring.ioc.dependencyinjection.constructor.manyconstructors;

/**
 * Created by treey.qian on 2017/8/30.
 */
public class Human {
    private long number;
    private String name;

    public Human() {
    }

    public Human(long number) {
        this.number = number;
    }

    public Human(String name) {
        this.name = name;
    }

    public Human(long number, String name) {
        this.number = number;
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class InnerInfo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "InnerInfo{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class StaticInnerInfo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "StaticInnerInfo{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
