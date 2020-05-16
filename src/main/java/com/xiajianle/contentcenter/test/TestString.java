package com.xiajianle.contentcenter.test;

import java.util.concurrent.ThreadLocalRandom;

public class TestString {

    public static void main(String[] args) {
        int i = ThreadLocalRandom.current().nextInt(2);
        System.out.println("i = " + i);
       /* String a = "abc";
        String b = "abc";
        //因为a和b都在常量池中
        System.out.println(a == b);

        String c = "c";
        String cc = new String("c");
        System.out.println(c == cc);

        String d = "d";
        String dd = new String("d").intern();
        System.out.println(d == dd);

        String e = "e";
        String ee = new String("e");
        ee.intern();
        System.out.println(e == ee);
*/
     /*  String a = new String("a");
       a.intern();
       String b = new String("a");
       b.intern();
       *//* String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";*//*
        System.out.println(a == b);*/

    }
    public void abc()
    {
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
    }
}
