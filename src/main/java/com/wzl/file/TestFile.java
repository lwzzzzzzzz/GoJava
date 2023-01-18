package com.wzl.file;

import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        File f = new File("src/main/java/com/wzl/file"); // java的相对目录是工程目录为起始目录;即GoJava目录
        System.out.println(f.getAbsoluteFile());
        for (String s : f.list()) {
            System.out.println(s);
        }
        for (File file : f.listFiles()) {
            System.out.println(file);
        }
        f.delete(); // 目录非空，del不生效
        File ff = new File("src\\main\\java\\com\\wzl\\file\\asd");
        ff.delete(); // 目录空，del生效
    }
}
