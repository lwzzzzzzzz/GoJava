package com.wzl.polymorphic;

public class Bird extends Animal implements Wings{
    String color = "blue";
    @Override
    public void run() {
        System.out.println("bird run");
    }

    @Override
    public void fly() {
        System.out.println("bird fly");
    }

    public void my() {
        System.out.println("my");
    }
}

class T {
    /**
        多态可以方便类的替换：1、Animal a = new Bird(); Bird可以随时换成Chicken类做它的业务逻辑，方便拔插。
                          2、go(a); 在函数调用可以接受一切继承它的子类，扩展性强
        但是多态下不能用子类的独有功能 a.my();报错，只能强转后调用 ((Bird) a).my();
     */
    public static void main(String[] args) {
        Bird b = new Bird();
        System.out.println(b.color);
        System.out.println(Wings.color);

        Animal a = new Bird();
        System.out.println(a.color); // 多态获取属性只认声明的类型，即Animal类  ----变量不存在多态，声明是啥类就访问啥类的
        a.run(); // 多态获取方法时，认new出来的类，即Bird类  ----需要跑方法，多态如果跑父类（接口），可能根本直接报错，所以也必须跑子类的
        go(a);

        Wings w = new Bird();
        System.out.println(w.color); // 打印Wings.color

    }

    public static void go(Animal a) {
        a.run();
//        a.my(); // 报错
        if (a instanceof Bird) {
            ((Bird) a).my();
        }
    }
}