package com.itcast.basic.threadtype.threadprofile;

/**
 * Created by qfl on 16/4/22.
 * 对于java thread的思考:
 * java中实现Thread的方法包括实现(implements)Runnable接口或者继承(extends)Thread类
 * 对Runnable接口的思考:Runnable接口仅有一个返回值为void的抽象方法(run方法)
 */
public class ImplementationMethodOfThreadClass {
    public static void main(String[] args) {
        new Thread(new SecondThreadBean()).start();
        new FirstThreadBean().start();
    }

}

class FirstThreadBean extends Thread {
    @Override
    public void run() {
        System.out.println("这是一个继承Thread类的线程");
    }
}

class SecondThreadBean implements Runnable {

    @Override
    public void run() {
        System.out.println("这是一个实现Runnable接口的线程");
    }
}