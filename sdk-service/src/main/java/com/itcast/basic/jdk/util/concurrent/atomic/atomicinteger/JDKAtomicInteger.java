package com.itcast.basic.jdk.util.concurrent.atomic.atomicinteger;

/**
 * Created by treey.qian on 2018/3/23.
 */
public class JDKAtomicInteger {
    private volatile int value;

    public JDKAtomicInteger() {

    }

    public JDKAtomicInteger(int value) {
        this.value = value;
    }

    public final int getAndSet(int newValue) {
        int old = get();
        do {
            value = newValue;
        } while (get() != newValue);
        return old;
    }

    public final int addAndGet(int value) {
        int old = get();
        int except = old + value;
        do {
            this.value += value;
        } while (get() < except);
        return get();
    }

    public final int getAndAdd(int value) {
        int old = get();
        int except = old + value;
        do {
            this.value += value;
        } while (get() < except);
        return old;
    }

    public final int get() {
        return value;
    }

    public final void set(int newValue) {
        this.value = newValue;
    }

    public final int incrementAndGet() {
        int old = get();
        int expect = old + 1;
        do {
            value++;
        } while (value < expect);
        return get();
    }

    public final int decrementAndGet() {
        int old = get();
        int expect = old + 1;
        do {
            value--;
        } while (value < expect);
        return get();
    }

    public final int getAndIncrement() {
        int old = get();
        int expect = old + 1;
        do {
            value++;
        } while (value < expect);
        return old;
    }

    public final int getAndDecrement() {
        int old = get();
        int expect = old - 1;
        do {
            value--;
        } while (value < expect);
        return old;
    }

    public final long longValue() {
        return (long) get();
    }

    public final int intValue() {
        return value;
    }

    public final float floatValue() {
        return (float) get();
    }

    public final double doubleValue() {
        return (double) get();
    }

    @Override
    public String toString() {
        return "JDKAtomicInteger{" +
                "value=" + value +
                '}';
    }
}
