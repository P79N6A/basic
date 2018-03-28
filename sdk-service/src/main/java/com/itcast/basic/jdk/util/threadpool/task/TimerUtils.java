package com.itcast.basic.jdk.util.threadpool.task;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by qfl on 2018/3/18.
 */
public class TimerUtils {

    private static final Timer timer = new Timer();

    /**
     * 定点执行
     *
     * @param timerTask
     * @param date      执行时间戳
     */
    public static void doJob(TimerTask timerTask, Date date) {

        timer.schedule(timerTask, date);
    }

    /**
     * 延迟执行
     *
     * @param timerTask
     * @param delayTime 延迟时间
     */
    public static void doJob(TimerTask timerTask, long delayTime) {
        timer.schedule(timerTask, delayTime);
    }


    /**
     * @param timerTask
     * @param delayTime 延迟时间
     * @param perid     间隔时间
     */
    public static void doJob(TimerTask timerTask, long delayTime, long perid) {
        timer.scheduleAtFixedRate(timerTask, delayTime, perid);
//        timer.schedule(timerTask, delayTime, perid);
    }

    /**
     * @param timerTask
     * @param date      执行时间戳
     * @param perid     时间间隔
     */
    public static void doJob(TimerTask timerTask, Date date, long perid) {
        timer.scheduleAtFixedRate(timerTask, date, perid);
//        timer.schedule(timerTask, date, perid);
    }

    public static void close() {
        timer.cancel();
    }
}
