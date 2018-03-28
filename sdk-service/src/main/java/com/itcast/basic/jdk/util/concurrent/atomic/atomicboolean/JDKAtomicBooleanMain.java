package com.itcast.basic.jdk.util.concurrent.atomic.atomicboolean;

/**
 * Created by treey.qian on 2018/3/23.
 */
public class JDKAtomicBooleanMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKAtomicBooleanMain");
            JDKAtomicBoolean jdkAtomicBoolean = new JDKAtomicBoolean(false);
            boolean oldValue = jdkAtomicBoolean.getAndSet(true);
            System.out.println("oldValue=" + oldValue + " newValue=" + jdkAtomicBoolean.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
