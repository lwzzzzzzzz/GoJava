package com.wzl.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestCollect {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");

        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            String ele = it.next();
            if ("a".equals(ele)) {
                System.out.println(ele);
                it.remove();
            }
        }

        System.out.println(s);

        for(String s1 : s) {
            s.remove(s1);
        }
        System.out.println(s);

    }
}
