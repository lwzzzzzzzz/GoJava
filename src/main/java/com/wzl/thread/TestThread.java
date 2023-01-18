package com.wzl.thread;

public class TestThread {
    public static void main(String[] args) {

        // 方式一 直接继承Thread，重写run方法实现自己的功能，缺点是不能继承别的类了。
        MyThread mt = new MyThread("my thread");
        mt.start();

        // 方式二 实现Runnable，重写run方法，再用线程封装后，得到线程。
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr, "my runnable");
        t1.start();

        // 方式三 因为Runnable是函数接口，可以用匿名内部类代替
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymous implements Runnable name: " + MyThread.currentThread().getName());
            }
        }, "my anonymous runnable");
        t2.start();

        System.out.println("main name: "+ Thread.currentThread().getName());
    }
}


class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("extends Thread name: " + MyThread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("implements Runnable name: " + MyThread.currentThread().getName());
    }
}
