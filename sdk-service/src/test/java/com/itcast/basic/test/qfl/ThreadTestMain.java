package com.itcast.basic.test.qfl;

/**
 * Created by treey.qian on 2017/9/6.
 */
public class ThreadTestMain {

    private volatile static int a = 0;

    public static void main(String[] args) {
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            br.readLine();
//            createBusyThread();
//            br.readLine();
//            createLockThread(new Object());
//            br.readLine();
//            for (int i = 0; i < 100; i++) {
//            new Thread(new Sync(1, 2)).start();
//            new Thread(new Sync(2, 1)).start();
//            }
//            for (int i = 0; i < 10; i++) {
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(200);
//                            System.out.println("a=" + (a++));
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                thread.start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("i=" + callerRes0());
//        ClassLoader classLoader = (new ThreadTestMain()).getClass().getClassLoader();
//        System.out.println("classLoader=" + classLoader.getParent());
        char c = 'a';
        int s = a;
        System.out.println("");
    }

    private static int callerRes0() {
        int i = 0;
        if (i == 0) {
            return i;
        }
        return i;
    }

    private static int callerRes1() {
        int i;
        try {
            i = 1;
//            int k=i/0;
            System.out.println("enter into callerRes " + i);
        } catch (Exception e) {
            i = 2;
            System.out.println("enter into Exception " + i);
        } finally {
            i = 3;
            System.out.println("enter into finally " + i);
        }
        return i;
    }

    private static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) ;
            }
        }, "testBusyThread");
        thread.start();
    }

    private static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    static class Sync implements Runnable {
        int a, b;

        public Sync(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println("a+b=" + (a + b));
                }
            }
        }
    }
}
