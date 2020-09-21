package com.book.effectivejava.chap7.issue42;

import java.io.*;
import java.util.Comparator;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:57 2020-09-21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class CreatingStreams {
    public static void main(String[] args) {
        //Comparator<Integer> cmp = (x,y)->Integer.compareUnsigned((int)x,(int)y);
        //实现了Lambda表达式的序列化 强转
        Comparator<Integer> cmp = (Comparator<Integer> & Serializable) (x,y)->Integer.compareUnsigned((int)x,(int)y);
        int i = 10;
        int j = -5;
        System.out.println(cmp.compare(i,j));

        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(cmp);
            obs.close();
            System.out.println("a");
            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cmp = (Comparator)ois.readObject();
            ois.close();
            System.out.println("b");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("c");
        }
        System.out.println(cmp.compare(i, j));
    }
}
