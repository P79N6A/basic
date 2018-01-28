package com.itcast.basic.threadtype.concurrentthread;

import java.util.concurrent.*;

/**
 * Created by qfl on 16/4/24.
 * 带返回值的任务执行
 */
public class FutureAndCallableClass {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<Long> futureTask = new FutureTask<Long>(new CallBack());
        new Thread(futureTask).start();
        System.out.println("线程返回值为:" + futureTask.get());

        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 123456;
            }
        });
        new Thread(integerFutureTask).start();
        System.out.println("返回值为:" + integerFutureTask.get());
    }
}

class CallBack implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        return System.currentTimeMillis();
    }
}

//class ExceTask implements Future<Integer>, Runnable {
//
//    private Callable callable;
//    private Object object;
//
//    public ExceTask(Callable callable) {
//        this.callable = callable;
//    }
//
//    @Override
//    public boolean cancel(boolean mayInterruptIfRunning) {
//        return false;
//    }
//
//    @Override
//    public boolean isCancelled() {
//        return false;
//    }
//
//    @Override
//    public boolean isDone() {
//        return false;
//    }
//
//    @Override
//    public Integer get() throws InterruptedException, ExecutionException {
//        return (Integer) object;
//    }
//
//    @Override
//    public Integer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
//        return null;
//    }
//
//    @Override
//    public void run() {
//        try {
//            object = callable.call();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
