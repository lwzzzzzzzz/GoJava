package com.wzl.generic;

import java.util.ArrayList;
import java.util.List;


// 泛型接口实际上就是 正常接口 + 传入数据的类型，这样继承该接口后，Override的方法用实现接口类替换。
public class GenericInterface implements Data<String>{

    @Override
    public void add(String arrayList) {

    }
}


