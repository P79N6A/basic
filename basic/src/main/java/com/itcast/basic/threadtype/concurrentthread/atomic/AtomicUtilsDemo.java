package com.itcast.basic.threadtype.concurrentthread.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by qfl on 16/4/25.
 * 枚举Atomic包中的类
 */
public class AtomicUtilsDemo {
    public static void main(String[] args) {
        /**
         * 基本数据类型的原子操作利用Integer转换
         */
        AtomicInteger atomicInteger = new AtomicInteger(12);

        //给定的值如果等于期望值则用新值更新
        boolean isUpdate = atomicInteger.compareAndSet(12, 13);
        //返回相加后的值
        Integer i = atomicInteger.addAndGet(1);
        //返回自增前的值
        Integer j = atomicInteger.incrementAndGet();
        //返回自减后的值
        Integer k = atomicInteger.decrementAndGet();

        System.out.println(k);
        System.out.println(isUpdate);
        System.out.println(j);
        System.out.println(i);
        System.out.println(atomicInteger);

        /**
         * 整型数组的原子操作
         */
        int[] arr = {1, 2, 3, 4, 5, 6};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        //对数组中指定位置的元素加2
        atomicIntegerArray.addAndGet(0, 2);
        System.out.println(atomicIntegerArray.get(0));
        //对数组中指定位置的元素自增
        atomicIntegerArray.decrementAndGet(1);
        System.out.println(atomicIntegerArray.get(1));

        /**
         * 引用数组的原子操作
         */
        User user = new User(1, "Lucy");
        User newUser = new User(2, "Lily");
        AtomicReference<User> userAtomicReference = new AtomicReference<User>();
        userAtomicReference.set(user);
        userAtomicReference.compareAndSet(user, newUser);
        System.out.println(userAtomicReference.get().getName());

        /**
         * 域字段的原子操作
         */
        AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "id");
        atomicIntegerFieldUpdater.getAndSet(user, 3);
        System.out.println(user.getId());
    }

    static class User {
        private String name;
        public volatile int id;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}














