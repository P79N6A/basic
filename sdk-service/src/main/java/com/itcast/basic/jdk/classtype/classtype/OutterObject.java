package com.itcast.basic.jdk.classtype.classtype;

/**
 * Created by Administrator on 2018/2/3.
 */
public class OutterObject {

    private int index;

    private static final long UID = 123456789l;


    public static void sysInnerName() {
        System.out.println("name of inner class is " + InnerObject.name);
    }


    public void create() {
        class Instance {
            {
                System.out.println("我是一个局部内部类");
            }

            public Instance() {

            }

            public void sys(String name) {
                System.out.println("name is " + name);
            }
        }

        Instance instance = new Instance();

        String name = "admin";
        instance.sys(name);

    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    static class InnerObject {
        private final static String name;

        static {
            System.out.println("enter into static inner class static-block");
            name = "inner";
        }

        {
            System.out.println("enter into static inner class  block");
        }


    }

    class InnerObject0 {

        private final String value;

        {
            System.out.println("enter into inner class  block" + UID + " index is " + index);
            value = "InnerObject0";
        }

        public InnerObject0() {

        }
    }

    @Override
    public String toString() {
        return "OutterObject{" +
                "index=" + index +
                '}';
    }
}
