package com.wzl.annotation;

public @interface MyAnno {
    public String name() default "";
    int age();
    int[] array();
}
