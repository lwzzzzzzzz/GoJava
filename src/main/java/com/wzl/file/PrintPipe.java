package com.wzl.file;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintPipe {
    public static void main(String[] args) throws Exception{
        try (
                // 字节打印流
                PrintStream ps = new PrintStream(new FileOutputStream("src/main/java/com/wzl/file/iotest2print_stream.txt"));
                // 字符打印流
                PrintWriter pw = new PrintWriter(new FileWriter("src/main/java/com/wzl/file/iotest2print_writer.txt"));
                // 两者在print上无区别
            ) {
            // System.out 就是 PrintStream 的一个实例，只不过输出的位置是console到显示器，而我们自己定义的PrintStream输出位置是磁盘文件。
            ps.println("ads");
            ps.println(1+1);
            ps.write(107);

            pw.print("ad");
            pw.println("adfff");

            //  当设置System.setOut，则可以改变输出位置，System.out.println则会写到ps打印流的位置。
            System.setOut(ps);
            System.out.println("1231235");
        }
    }
}
