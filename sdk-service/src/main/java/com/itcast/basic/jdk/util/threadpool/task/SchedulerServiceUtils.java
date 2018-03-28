package com.itcast.basic.jdk.util.threadpool.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by qfl on 2018/3/18.
 */
public class SchedulerServiceUtils {
    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();


    /**
     * @param runnable
     * @param delay    延迟时间
     * @param unit     单位
     */
    public static void doJob(Runnable runnable, long delay, TimeUnit unit) {
        scheduler.schedule(runnable, delay, unit);
    }

    /**
     * @param runnable 过delay后执行第一次
     * @param delay    延迟时间
     * @param period   时间间隔
     * @param unit     时间单位
     */
    public static void doJob(Runnable runnable, long delay, long period, TimeUnit unit) {
        scheduler.scheduleAtFixedRate(runnable, delay, period, unit);
    }

    /**
     * @param runnable 过delay+period后执行第一次
     * @param delay    延迟时间
     * @param period   时间间隔
     * @param unit     时间单位
     */
    public static void doJob0(Runnable runnable, long delay, long period, TimeUnit unit) {
        scheduler.scheduleWithFixedDelay(runnable, delay, period, unit);
    }

    public static void close() {
        scheduler.shutdown();
    }
}
