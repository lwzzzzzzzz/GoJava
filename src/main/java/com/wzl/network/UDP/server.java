package com.wzl.network.UDP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class server {
    public static void main(String[] args) throws IOException {
        // 注册端口号
        DatagramSocket socket = new DatagramSocket(23333);

        // 接收数据包
        byte[] buffer = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // 等待接收数据
        socket.receive(packet);

        String rs = new String(buffer, 0, packet.getLength()); // 确定取buffer内多少的字节，如不确定，则后面就是乱码
        System.out.println(rs);
    }
}
