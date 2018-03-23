package com.itcast.basic.jdk.util.concurrent.atomic.atomicboolean;

/**
 * Created by treey.qian on 2018/3/23.
 */
public class JDKAtomicBoolean {

    private volatile int value;

    public JDKAtomicBoolean() {

    }

    public JDKAtomicBoolean(boolean newValue) {
        value = newValue ? 1 : 0;
    }

    public final boolean compareAndSet(boolean except, boolean update) {
        int exceptValue = except ? 1 : 0;
        int updateValue = update ? 1 : 0;
        if (this.value == exceptValue) {
            value = updateValue;
        }
        return true;
    }

    public final boolean getAndSet(boolean newValue) {
        boolean except;
        do {
            except = get();
        } while (!compareAndSet(except, newValue));

        return except;
    }

    public final void set(boolean newValue) {
        value = newValue ? 1 : 0;
    }

    public final boolean get() {
        return value != 0;
    }

    @Override
    public String toString() {
        return "JDKAtomicBoolean{" +
                Boolean.toString(get()) +
                '}';
    }
}
