package com.wzl.more;

//@Getter
public class Robot{

    private int id;

    public static int rr;

    private String name;

    public static int show() { // 只能拿static修饰的变量
        return rr;
    }

    public Robot(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Robot() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

