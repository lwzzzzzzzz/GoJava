package com.wzl.polymorphic;

public interface Wings {
    String color = "red"; // 默认public final static，所以一般不在interface内定义变量
    public abstract void fly();

    // 接口不能有构造方法
//    public Wings() {
//
//    }
}
