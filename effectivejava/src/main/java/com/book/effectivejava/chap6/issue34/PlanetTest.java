package com.book.effectivejava.chap6.issue34;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 11:35 2020-09-20
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class PlanetTest {

    public static void main(String[] args) {
        //第一种
        //System.out.println(PlanetOperationEnum.PLUS.apply(1.0,2.0));
        //第二版 似乎没什么不同
        //System.out.println(PlanetOperationEnum.PLUS.apply(1.0,2.0));

        for(PlanetOperationEnum op : PlanetOperationEnum.values()){
            System.out.println(op);
        }
        System.out.println(PlanetOperationEnum.values());


    }
}
