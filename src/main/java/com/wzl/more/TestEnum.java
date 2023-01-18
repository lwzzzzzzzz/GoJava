package com.wzl.more;

public enum TestEnum {
    // 枚举类其实是一种多例，其每一个枚举值都是一个被new出来的枚举类，且其枚举类的构造器是私有的
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
    private final int i;
    TestEnum(int i) {
        this.i = i;
    }

    public static void caseSwitch(TestEnum t) { // 传入应该是枚举类
        switch (t) {
            case SPRING: // 语法糖，不需要写TestEnum.SPRING
                System.out.println("spring");
                break;
            case SUMMER:
                System.out.println("summer");
                break;
        }
    }

    public static void main(String[] args) {
        caseSwitch(TestEnum.SPRING);
        for (TestEnum t: TestEnum.values()) {
            System.out.println(t);
        }
//        System.out.println(TestEnum.valueOf("Asdf"));
        System.out.println(TestEnum.valueOf("WINTER"));
    }
}
