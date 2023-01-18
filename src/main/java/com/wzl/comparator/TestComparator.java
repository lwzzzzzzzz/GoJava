package com.wzl.comparator;

import java.util.Arrays;
import java.util.Comparator;


class S {
    public String name;
    public double height;

    public S(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public String toString() {
        return this.name + " " + this.height;
    }
}

public class TestComparator {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 76, 34, 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = {2, 4, 1, 76, 34, 2};
        // Arrays.sort被重载之后，arr2需要传入引用类型数据
        Arrays.sort(arr2, new Comparator<Integer>() {
            // 看Comparator接口的return文档，可知，当返回的 信号量>0则交换; 信号量=0则不变（这里是否交换看是否需要排序的稳定性）; 信号量<0则交换;
            // 在Comparator告诉我们谁大之后，sort方法会把大的往后排，完成了排序操作
            // 所以当我们要逆序排序，实际大小o2>o1时，返回一个正数，则进行交换，实现把大的换到前面，从而倒序。
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr2));

        S[] ss = {new S("a", 170.3), new S("d", 172.3), new S("Ad", 170.6), new S("cba", 170.9)};
        Arrays.sort(ss, new Comparator<S>() {
            @Override
            public int compare(S o1, S o2) {
//                System.out.println(o1.name.compareTo(o2.name));
//                return o1.name.compareTo(o2.name); // compareTo函数默认当a>b时，a.compareTo(b)返回正数

//                return String.CASE_INSENSITIVE_ORDER.compare(o1.name, o2.name); // compareTo函数默认当a>b时，a.compareTo(b)返回正数
                return Double.compare(o1.height, o2.height); // compare函数默认当a>b时，Double.compare(a, b)返回正数

            }
        });

        System.out.println(Arrays.toString(ss));

    }

}
