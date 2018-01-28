package com.itcast.basic.threadtype.concurrentthread;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * Created by qfl on 16/4/24.
 * 本例演示java提供的系统的默认线程池的使用案例
 */
public class ExecutorsClass {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * 时间执行器Timer
         */
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("这是一个完成倒计时任务的处理器");
            }
        }, 2000);

        /**
         * 单线程池
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> f = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1314;
            }
        });
        System.out.println("线程返回值为:" + f.get());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个无返回值的线程任务执行器");
            }
        });
        executorService.shutdown();

        /**
         * 带返回值多线程执行器
         */
        ExecutorService cacheExecutorService = Executors.newCachedThreadPool();
        List<Callable<Long>> callableTaskLists = new ArrayList<Callable<Long>>();
        for (int i = 0; i < 10; i++)
            callableTaskLists.add(new Callable<Long>() {
                                      @Override
                                      public Long call() throws Exception {
                                          return System.currentTimeMillis();
                                      }
                                  }
            );
        List<Future<Long>> futureTask = cacheExecutorService.invokeAll(callableTaskLists);
        for (Future<Long> future : futureTask)
            System.out.println("返回值为:" + future.get());
        cacheExecutorService.shutdown();

        /**
         * 带返回值的执行器
         */
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Long> executorCompletionService = new ExecutorCompletionService<Long>(fixedExecutorService);
        for (int i = 0; i < 3; i++)
            executorCompletionService.submit(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    return System.currentTimeMillis();
                }
            });
        for (int i = 0; i < 3; i++)
            System.out.println("返回结果为:" + executorCompletionService.take().get());
        fixedExecutorService.shutdown();

        /**
         * 定时任务
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++)
            scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    System.out.println("系统当前时间为:" + System.currentTimeMillis());
                }
            }, 2, 1, TimeUnit.SECONDS);

    }
}
