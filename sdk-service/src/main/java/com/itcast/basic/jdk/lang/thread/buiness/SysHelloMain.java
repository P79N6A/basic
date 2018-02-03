package com.itcast.basic.jdk.lang.thread.buiness;

/**
 * Created by Administrator on 2018/2/3.
 * 主线程和子线程交替输出
 * 子线程循环10次，接着主线程循环100次，接着有回到子线程循环10次，
 * 接着再回到主线程循环100次，如此执行50次
 */
public class SysHelloMain {


    public static void main(String[] args) {
        try {
            System.out.println("enter into SysHelloMain");
            SysHelloObject sysHelloObject = new SysHelloObject();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 50; i++) {
                        try {
                            sysHelloObject.sysSub(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            for (int i = 0; i < 50; i++) {
                sysHelloObject.sysMain(100);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
