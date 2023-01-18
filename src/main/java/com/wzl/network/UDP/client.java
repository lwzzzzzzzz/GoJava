package com.wzl.network.UDP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class client {
    public static void main(String[] args) throws IOException {
        // 申请管道，并注册端口号（这里没给，随机端口）
        DatagramSocket socket = new DatagramSocket();

        //
        byte[] buffer = "client data".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
                InetAddress.getLocalHost(), 23333); // server的ip和接受端口

        socket.send(packet);

        // 关闭管道
        socket.close();
    }
}
