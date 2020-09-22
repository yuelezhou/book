package com.book.effectivejava.chap7.issue43;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 17:23 2020-09-21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class Test {

/**
 * If the specified key is not already associated with a value or is
 * associated with null, associates it with the given non-null value.
 * Otherwise, replaces the associated value with the results of the given
 * remapping function, or removes if the result is {@code null}. This
 * method may be of use when combining multiple mapped values for a key.
 * For example, to either create or append a {@code String msg} to a
 * value mapping:
 */
    public static void main(String[] args) {
        //{1=1, 2=2, 3=3}
        //{1=100, 2=2, 3=3}
//        Map<Object,Integer> map = new HashMap<>();
//        Integer key = 1;
//        map.put(1,1);
//        map.put(2,2);
//        map.put(3,3);
//        System.out.println(map);
//        map.merge(key,99,Integer::sum);
//        System.out.println(map);

        //{2=2, 3=3}
        //{1=99, 2=2, 3=3}
        Map<Object,Integer> map = new HashMap<>();
        Integer key = 1;
        //map.put(1,null);
        map.put(2,2);
        map.put(3,3);
        System.out.println(map);
        map.merge(key,99,Integer::sum);
        System.out.println(map);




    }

}
