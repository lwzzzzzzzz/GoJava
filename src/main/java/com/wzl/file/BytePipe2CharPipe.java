package com.wzl.file;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BytePipe2CharPipe {

    public static void main(String[] args) throws IOException {
        try (
                // 可以看到封装的过程是 原始字节流 -> 字符流 -> 缓冲字符流
                //      实际上，我们直接使用到的new FileReader创建字符流，点进去源码也是对原始字节流的封装
            InputStream is = new FileInputStream("src/main/java/com/wzl/file/iotest.txt"); // 原始字节输入流
            Reader isr = new InputStreamReader(is, "GBK");  // 封装转化为（指定编码方式）字符流
            BufferedReader fs = new BufferedReader(isr); // 再包装成缓冲字符流

            OutputStream os = new FileOutputStream("src/main/java/com/wzl/file/iotest2charset.txt");
            Writer osw = new OutputStreamWriter(os, "GBK");
            BufferedWriter bw = new BufferedWriter(osw);

        ) {
//            int len;
//            while ((len = isr.read()) != -1) {
//                System.out.println((char) len);
//            }
            String s;
            while ((s = fs.readLine()) != null) {
                System.out.println(s);
                bw.write(s);
                bw.newLine();
            }
        }
    }
}
