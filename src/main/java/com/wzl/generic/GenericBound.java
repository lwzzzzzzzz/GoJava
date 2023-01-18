package com.wzl.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericBound {

//    “?”表示无上下界
//    “? extends classA”表示以classA为上界,即以classA为父类
//    “? super classA”表示以classA为下界,即以classA为子类
    public static void main(String[] args) {

        List<BMW> bmws = new ArrayList<>();
        bmws.add(new BMW());
        bmws.add(new BMW());
        bmws.add(new BMW());
        go(bmws);

        List<BENZ> benz = new ArrayList<>();
        benz.add(new BENZ());
        benz.add(new BENZ());
        benz.add(new BENZ());
        go(benz);


        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());
//        go(dogs);  // 当List<?>时，表示所有类型都能接受，规定上界之后，则不能传入


        List<Object> dogObjects = new ArrayList<>();
        // 这里能add是因为，Dog和Object是父子关系，而对于泛型接口来说List<Dog>和List<Object>之间没有继承关系
        dogObjects.add(new Dog());
        dogObjects.add(new Dog());
        dogObjects.add(new Dog());
    }

    // 因为List是一个泛型接口，而泛型定义好了类型，是不可变的。即对于任何2个不同类型的type1和type2，List<Type1>即不是List<Type2>的子类型，也不是List<Type2>的超类型。
    // 也就是String和Object是父子关系，但是List<String>和List<Object>之间没有继承关系。
//    public static void go(List<?> car) {
    public static void go(List<? extends Car> car) {
//    public static void go(List<Object> car) { // 报错

    }
}


class Dog {

}


class BMW extends Car {

}


class BENZ extends Car {

}


abstract class Car{

}

