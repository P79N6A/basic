package com.itcast.basic.threadtype.concurrentthread;

import java.util.concurrent.*;

/**
 * Created by qfl on 16/4/24.
 */
public class BigNumberClass {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * 并行计算
         */
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(new CountNumber(0, 1000000));
        System.out.println("计算结果为: " + forkJoinTask.get());
    }
}

class CountNumber extends RecursiveTask<Integer> {
    private final int TEMPVALUE = 1000;
    private int begin;
    private int end;

    public CountNumber(int min, int max) {
        this.begin = min;
        this.end = max;
    }

    @Override
    protected Integer compute() {
        Integer result = 0;
        if (end - begin < TEMPVALUE) {
            for (int i = begin; i < end; i++)
                result += i;
        } else {
            int mid = (end + begin) % 2 == 0 ? (end + begin) / 2 : (end + begin) / 2 + 1;
            CountNumber leftCountNumber = new CountNumber(begin, mid);
            leftCountNumber.fork();
            CountNumber rightCountNumber = new CountNumber(mid, end);
            rightCountNumber.fork();
            int left = leftCountNumber.join();
            int right = rightCountNumber.join();
            result = left + right;
        }
        return result;
    }
}
