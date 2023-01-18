package com.wzl.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class ip {

    public static void main(String[] args) throws IOException {
        // 本地ip
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println(ip1.getHostAddress());
        System.out.println(ip1.getHostName());

        // 公网域名ip
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.getHostName());

//        // 公网ip
        InetAddress ip3 = InetAddress.getByName("180.97.34.96");
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.getHostName());

        // ping ip
        System.out.println(ip2.isReachable(500));
    }
}
