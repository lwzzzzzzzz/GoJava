package com.wzl.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestDecodeEncode {
    public static void main(String[] args) throws IOException {
//        String s = "lwz大松";
//        byte[] bs = s.getBytes(StandardCharsets.UTF_8);
//        System.out.println(Arrays.toString(bs));
//        String ss = new String(bs, StandardCharsets.UTF_8);
//        System.out.println(ss);

        InputStream is = new FileInputStream("src/main/java/com/wzl/file/iotest.txt");

//        // 一个一个字节去读 效率低
//        int eachChar = is.read(); // int为4byte，所以可以用来接字节流的任意一个字节
//        while (eachChar != -1) { // io字节流，读到最后-1为结束
//            System.out.println(eachChar);
//            System.out.println((char)eachChar);
//            eachChar = is.read();
//        }

//        // 每次取一个buffer的字节
//        byte[] buffer = new byte[3]; // 每次读3B大小的字节，每次读了的字节都存在buffer内
//        InputStream is1 = new FileInputStream("src/main/java/com/wzl/file/iotest.txt");
//        int len1 = is1.read(buffer); // read返回buffer内array的长度
//        while (len1 >= 0) {
////            System.out.print(Arrays.toString(buffer));
//            System.out.print(new String(buffer, 0, len1)); // 读buffer内有效长度
//            len1 = is1.read(buffer);
//        }



        // 写数据
        byte[] buffer1 = new byte[3];
        InputStream is2 = new FileInputStream("src/main/java/com/wzl/file/iotest.txt");
        OutputStream os = new FileOutputStream("src/main/java/com/wzl/file/out_test.txt", true);
        OutputStream os2 = new FileOutputStream("src/main/java/com/wzl/file/out_test2.txt", true);
        os2.write("adsfasdfsfsfs士大夫adf".getBytes(StandardCharsets.UTF_8));

        FileWriter fileWriter = new FileWriter("src/main/java/com/wzl/file/out_test3.txt");
        fileWriter.write("今天打工你不狠，明天地位就不稳\n" +
                "今天打工不勤快，明天社会就淘汰");
        fileWriter.flush();
        fileWriter.write("今天打工你不狠");
        fileWriter.close();

        int len2 = is2.read(buffer1);
        while (len2 > 0) {
            System.out.println(new String(buffer1));
            os.write(buffer1, 0, len2);
            os.flush();
            len2 = is2.read(buffer1);
        }

        os.close(); // 关流释放资源。一般放在try catch finally里的finally内部
        is2.close();

    }
}
