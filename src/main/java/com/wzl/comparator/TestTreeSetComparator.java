package com.wzl.comparator;

import java.util.*;

public class TestTreeSetComparator {
    public static void main(String[] args) {
        Set<Dog> s = new TreeSet<>(new Comparator<Dog>() { // 这里是直接针对TreeSet定义了Comparator，使之完成比较。优先使用集合自带的比较器（就近原则）
            @Override
            public int compare(Dog o1, Dog o2) {
                return o2.getAge() - o1.getAge(); // 对于treeSet而言当比较函数等于0时，认为两者一样，Set定义会将其去掉。
            }
        });

        s.add(new Dog("a", 2));
        s.add(new Dog("b", 4));
        s.add(new Dog("c", 2));
        s.add(new Dog("c", 3));
        System.out.println(s);

        Set<Dog> s1 = new TreeSet<>(); // 内部调用了Dog实现的implements Comparable<Dog>接口，实现了比较
        s1.add(new Dog("a", 2));
        s1.add(new Dog("b", 4));
        s1.add(new Dog("c", 2));
        s1.add(new Dog("c", 3));
        System.out.println(s1);


        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        l1.add("c");
        l1.add("d");

        Collections.sort(l1);

    }

}

