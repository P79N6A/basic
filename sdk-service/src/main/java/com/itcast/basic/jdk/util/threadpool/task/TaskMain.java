package com.itcast.basic.jdk.util.threadpool.task;

import com.itcast.basic.jdk.util.common.CommonUtils;
import com.itcast.basic.jdk.util.common.TimeModel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by qfl on 2018/3/18.
 */
public class TaskMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into TaskMain");
            System.out.println("now is " + System.currentTimeMillis());
            Date date = CommonUtils.initDate(TimeModel.SECOND, 5);
//            TimerTask timerTask = new TimerTask() {
//                @Override
//                public void run() {
//                    System.out.println("job begin time is " + System.currentTimeMillis());
//                }
//            };

//            TimerUtils.doJob(timerTask, date);
//            TimerUtils.doJob(timerTask, 1000);
//            TimerUtils.doJob(timerTask, 5 * 1000, 1000);
//            TimerUtils.doJob(timerTask,date, 1000);
//            TimerUtils.close();

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("job begin time is " + System.currentTimeMillis());
                }
            };
//            SchedulerServiceUtils.doJob(runnable, 5, TimeUnit.SECONDS);
//            SchedulerServiceUtils.doJob(runnable, 5, 1, TimeUnit.SECONDS);
            SchedulerServiceUtils.doJob0(runnable, 5, 1, TimeUnit.SECONDS);
//            SchedulerServiceUtils.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
