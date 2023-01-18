package com.wzl.thread.lock;

public class ThreadLock {

    public static void main(String[] args) {
        Account acc = new Account("acc1", 1000);

        // t1 t2可能同时对账户操作，如不对取钱加锁，可能导致取钱出现很异常的情况
        Thread t1 = new Thread(new MyRunnable(acc), "Ming");
        t1.start();
        Thread t2 = new Thread(new MyRunnable(acc), "Hong");
        t2.start();
    }
}


class MyRunnable implements Runnable {

    private final Account acc;

    public MyRunnable(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.drawMoney(1000);
    }
}
