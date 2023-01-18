package com.wzl.file.serialize;

import com.wzl.comparator.Dog;

import java.io.*;

public class TestObjectPipe {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Dog d = new Dog("nick", 5);


        try (
                OutputStream os = new FileOutputStream("src/main/java/com/wzl/file/serialize/oos2serial.txt"); // 先定义原始字节流
                ObjectOutputStream oos = new ObjectOutputStream(os); // 封装原始字节流变成对象字节流。使之实现序列化

                InputStream is = new FileInputStream("src/main/java/com/wzl/file/serialize/oos2serial.txt");
                ObjectInputStream ois = new ObjectInputStream(is);
                ) {
            oos.writeObject(d); // 此时需要d所代表的类，实现了Serializable接口，否则不能被序列化

            Dog d1 = (Dog) ois.readObject(); // 反序列化
            System.out.println(d1);
        }
    }
}
