package com.wzl.polymorphic;

import javax.swing.*;


public class TestLambda {
    public static void main(String[] args) {
        // 都说接口没有构造方法，但是这里又能用new关键字？是不是矛盾了？、
        // 实际上new Wings() {必须带大括号即必须带函数体，去重写方法（如有）}
        //      javap反编译可以看见，其实这只是new了一个实现了该接口的匿名内部类，又因为是匿名的，所以只能用Wings的句柄代替之
        Wings w = new Wings() {
            @Override
            public void fly() {
                System.out.println("i can fly");
            }
        };
        w.fly();

        Wings w2 = new Wings() {
            @Override
            public void fly() {
                System.out.println("u can fly");
            }
        };
        w2.fly();

        w = w2;
        w.fly();
    }
}
