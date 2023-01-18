package com.wzl.file;

import java.io.*;

public class TryCatchResource {

    public static void main(String[] args) {
        // 把管道等资源放在try内，可以不用手动释放
        try (InputStream is2 = new FileInputStream("src/main/java/com/wzl/file/iotest.txt");
             OutputStream os = new FileOutputStream("src/main/java/com/wzl/file/out_test.txt", true);
             ) {
            System.out.println((char) is2.read());
            os.write(97);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
