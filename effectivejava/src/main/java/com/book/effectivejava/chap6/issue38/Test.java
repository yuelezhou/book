package com.book.effectivejava.chap6.issue38;

import java.util.Arrays;
import java.util.Collection;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 18:25 2020-09-20
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class Test {
    public static void main(String[] args) {
//        double x = Double.parseDouble(args[0]);
//        double y = Double.parseDouble(args[1]);
        //无法执行
        Test.test(ExtendedOperation.class,0.1,0.1);
        Test.test(Arrays.asList(ExtendedOperation.values()),0.1,0.2);
    }

    private static <T extends Enum<T> & Operation> void  test(
            Class<T> opEnumType,double x,double y){
        for (Operation op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x,y));
    }

    private static void  test(Collection<? extends Operation> opSet,double x, double y){
        for (Operation op : opSet)
            System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x,y));
    }
}
