package com.wzl.thread.lock;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private String id;
    private double money;
    private final Lock lock = new ReentrantLock(); // 为每一个账户创建一个取钱锁


    public Account(String id, double money) {
        this.id = id;
        this.money = money;
    }

    // 方式1 通过对函数体加锁
    // public synchronized void drawMoney(double draw) {
    public void drawMoney(double draw) {

////        方式2 对会产生线程问题的代码块加锁
//        synchronized (this) {
//            if (draw <= money) {
//                money -= draw;
//                System.out.println( Thread.currentThread().getName() + " draw: " + draw + ", left: " + money);
//            } else {
//                System.out.println("money insufficient.");
//            }
//        }

////        方式3 自定义创建锁
//        lock.lock();
//        try {
//            if (draw <= money) {
//                money -= draw;
//                System.out.println(Thread.currentThread().getName() + " draw: " + draw + ", left: " + money);
//            } else {
//                System.out.println("money insufficient.");
//            }
//        } finally {
//            lock.unlock(); // unlock放在finally避免try内报错，锁未释放
//        }


        if (draw <= money) {
            money -= draw;
            System.out.println( Thread.currentThread().getName() + " draw: " + draw + ", left: " + money);
        } else {
            System.out.println("money insufficient.");
        }

    }



    public String getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
