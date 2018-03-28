package com.itcast.basic.jdk.util.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by treey.qian on 2018/3/20.
 */
public class SimpleThreadPool {
    private int maxSize = Integer.MAX_VALUE;
    private int coreSize = 4;

    private BlockingQueue threads = new LinkedBlockingQueue();
    private BlockingQueue workers = new LinkedBlockingQueue();



}
