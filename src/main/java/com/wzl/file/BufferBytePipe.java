package com.wzl.file;

import java.io.*;

public class BufferBytePipe {
    public static void main(String[] args) throws IOException {

        try (
            InputStream is = new FileInputStream("src/main/java/com/wzl/file/g.jpg");
            // 封装一层，变成缓冲字节流，其区别在于加载字节流的方式，管道会预先自动加载8kb的数据到内存，字节流从内存取，而不是磁盘。
            //                          类似于操作系统课程里磁盘与内存之间存在的缓存区
            BufferedInputStream bis = new BufferedInputStream(is);
            OutputStream os = new FileOutputStream("src/main/java/com/wzl/file/g2.jpg");
            BufferedOutputStream bos = new BufferedOutputStream(os)
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        }
    }
}
