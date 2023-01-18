package com.wzl.comparator;

import com.wzl.polymorphic.Animal;

import java.io.Serializable;

public class Dog extends Animal implements Comparable<Dog>, Serializable { // 泛型接口来实验treeSet的比较类，使Dog类有了compare的能力

    private static final long serialVersionUID = 1; // 序列的版本号，当版本更新了，老版本被序列化的不能被反序列化回来
    private String name;
    private transient Integer age; // transient表示该变量不参与序列化（避免敏感信息泄露）

    public Dog() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void run() {
        System.out.println("Dog run");
    }

    @Override
    public int compareTo(Dog o) {
        return this.age - o.age; // 这里直接用了Dog类，避免了使用 泛型T 表示，结果找不到.age的方法
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
