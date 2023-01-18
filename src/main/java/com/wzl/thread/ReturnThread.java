package com.wzl.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ReturnThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1. 先实现callable接口
        // 2. 封装callable到FutureTask
        // 3. 封装FutureTask到thread
        // 4. thread实例.start后，FutureTask实例.get()拿到返回结果
        MyCallable mc = new MyCallable(0);
        FutureTask<String> ft = new FutureTask<>(mc);
        Thread t1 = new Thread(ft, "before_future_task");
        // t1.start(); // 当在这里start的时候，线程名字就是before_future_task

        for (int i = 0; i < 10; i++) { // 注意：一个FutureTask只能被线程加载一次，ft.get只能拿到第一次start ft任务的线程的结果，多个线程需要new多个FutureTask
            new Thread(ft, "after_future_task" + i).start();
        }
        t1.start();
        System.out.println(ft.get());


        // 循环实现多个线程。
        List<FutureTask<String>> ftList = new ArrayList<>();
        FutureTask<String> oneFt;
        for (int i = 0; i < 10; i++) {
            oneFt = new FutureTask<>(new MyCallable(i));
            ftList.add(oneFt);
            new Thread(oneFt, "my future_task_" + i).start();
        }
        for (FutureTask<String> eachFt: ftList) {
            System.out.println(eachFt.get());
        }


        System.out.println("main name: "+ Thread.currentThread().getName());

    }
}

class MyCallable implements Callable<String> { // 泛型函数接口
    private int threadIndex;

    public MyCallable(int threadIndex) {
        this.threadIndex = threadIndex;
    }

    @Override
    public String call() throws Exception {
//        for (int i = 0; i < 1000 - threadIndex; i++) {
//            int a = 1+1;
//        }
        return "callable -> FutureTask -> Thread: " + Thread.currentThread().getName() + ". threadIndex: " + threadIndex;
    }
}
