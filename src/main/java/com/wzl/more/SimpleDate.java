package com.wzl.more;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDate {
//    public static void main(String[] args) {
////        Robot r1 = new Robot(1, "wz");
////        Robot.rr = 1;
//        System.out.println(Robot.show());
//        for (TestEnum season : TestEnum.values()) {
//            System.out.println(season);
//        }
    public static void main(String[] args){
        SimpleDateFormat CeshiFmt0=new SimpleDateFormat("Gyyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat CeshiFmt1=new SimpleDateFormat("yyyy/MM/dd HH:mm");
        SimpleDateFormat CeshiFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat CeshiFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        SimpleDateFormat CeshiFmt4=new SimpleDateFormat("yyyy/MM/dd E");
        SimpleDateFormat CeshiFmt5=new SimpleDateFormat(
                "一年中的第 D 天 ，第w个星期 ，一个月中第W个星期 ，k时 z时区");
        Date now=new Date();
        System.out.println(CeshiFmt0.format(now));
        System.out.println(CeshiFmt1.format(now));
        System.out.println(CeshiFmt2.format(now));
        System.out.println(CeshiFmt3.format(now));
        System.out.println(CeshiFmt4.format(now));
        System.out.println(CeshiFmt5.format(now));
    }

}
