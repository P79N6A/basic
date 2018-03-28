package com.itcast.basic.jdk.util.threadpool.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by qfl on 2018/3/18.
 */
public class ThreadPoolsMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into ThreadPoolsMain");
            ExecutorService executorService = ThreadPoolUtils.initSingle();
//            Runnable runnable = () -> {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("hello world i am lily " + System.currentTimeMillis());
//            };
//
//            for (int i = 0; i < 10; i++) {
//                executorService.execute(runnable);
//            }
//
//            List<String> results = new ArrayList<>();
//            FutureTask<List> futureTask = new FutureTask(() -> {
//                results.add("success");
//            }, results);
//            executorService.execute(futureTask);
//            System.out.println("results is " + futureTask.get());
//
//            Future future = executorService.submit(() -> "success");
//            System.out.println("result is " + future.get());

            List tasks = new ArrayList();
            for (int i = 0; i < 20; i++) {
                int num = i;
                tasks.add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return num;
                    }
                });
            }
//            List<Future<Integer>> results = executorService.invokeAll(tasks);
//
//            for (Future future : results) {
//                System.out.println(" future ----> " + future.get());
//            }

            Object result = executorService.invokeAny(tasks);
            System.out.println(" result ----> " + result);

            ScheduledExecutorService scheduledExecutorService = ThreadPoolUtils.inintScheduler(3);
            scheduledExecutorService.schedule(() -> System.out.println("begin job"), 10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
