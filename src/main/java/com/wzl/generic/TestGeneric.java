package com.wzl.generic;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
    // 泛型是在编译的时候，用对应的类别替换掉（T E K V）符号
    public static void main(String[] args) {

        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");

        printArray(s);

    }

    public static <E> void printArray(List<E> e) { // 当方法需要被定义为泛型时，需要在两个地方加上对应标记
        if (e != null) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < e.size(); i++) {
                sb.append(e.get(i)).append(i == e.size() - 1 ? "": ", ");
            }
            System.out.println(sb.append("]"));
        } else {
            System.out.println((Object) null);
        }

    }
}
