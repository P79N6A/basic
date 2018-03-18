package com.itcast.basic.jdk.util.threadpool.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qfl on 2018/3/18.
 */
public class ThreadPoolUtils {

    //单线程线程池
    public static ExecutorService initSingle() {
        return Executors.newSingleThreadExecutor();
    }

    //缓存线程池
    public static ExecutorService initCached() {
        return Executors.newCachedThreadPool();
    }

    //fixed线程池
    public static ExecutorService initFixed(int size) {
        return Executors.newFixedThreadPool(size);
    }

}
