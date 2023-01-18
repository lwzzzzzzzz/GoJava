package com.wzl.file;

import java.io.*;

public class BufferCharPipe {
    // 字符缓冲流
    public static void main(String[] args) throws IOException {
        try (
            Reader fr = new FileReader("src/main/java/com/wzl/file/iotest.txt");
            BufferedReader br = new BufferedReader(fr); // 包装原始字符管道流
            Writer fw = new FileWriter("src/main/java/com/wzl/file/iotest11.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
//                bw.write(line + "\r\n");
                bw.write(line);
                bw.newLine();
            }

        }
    }
}
