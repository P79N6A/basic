package com.itcast.basic.test.qfl.inner;

/**
 * Created by treey.qian on 2018/2/2.
 */
public class OuterClassObject {

    public void sysName() {
        Inner inner = new Inner();
        System.out.println("name= " + inner.name);
    }

    class Inner {
        private String name = "lily";
    }
}
