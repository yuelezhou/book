package com.book.effectivejava.chap6.issue37;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 15:59 2020-09-20
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class Plant {
    enum LifeCycle{ANNUAL,PERENNIAL,BIENNIAL}

    final String name;

    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                '}';
    }

    //错误示范
//    public static void main(String[] args) {
//        //泛型数组 不安全
//        //Set<Plant>[] plantsByLifeCycle = new Set<Plant>[LifeCycle.values().length];
//        @SuppressWarnings(value = "unchecked")
//        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];
//        for (int i = 0; i < plantsByLifeCycle.length ; i++)
//            plantsByLifeCycle[i] = new HashSet<>();
//        for (Plant p : garden)
//            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
//        for (int i = 0; i < plantsByLifeCycle.length ; i++){
//            System.out.printf("%s:%s%n",Plant.LifeCycle.values()[i],plantsByLifeCycle[i]);
//        }
//    }

    public static void main(String[] args) {
//        List<Plant> garden = Arrays.asList(new Plant("玫瑰",LifeCycle.ANNUAL),new Plant("水仙",LifeCycle.BIENNIAL),new Plant("狗尾巴草",
//                LifeCycle.BIENNIAL));
          Plant[] garden = new Plant[]{new Plant("玫瑰",LifeCycle.ANNUAL),new Plant("水仙",LifeCycle.BIENNIAL)
                  ,new Plant("狗尾巴草", LifeCycle.BIENNIAL),new Plant("狗尾巴草", LifeCycle.BIENNIAL)};
        //第一种分类方式
//        Map<Plant.LifeCycle,Set<Plant>> plantsByLifeCycle = new EnumMap(Plant.LifeCycle.class);
//        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
//            plantsByLifeCycle.put(lc,new HashSet<>());
//        for (Plant p : garden)
//            plantsByLifeCycle.get(p.lifeCycle).add(p);
//        System.out.println(plantsByLifeCycle);
        //第二种分类方式 //函数默认返回List
        System.out.println(Arrays.stream(garden)
                .collect(Collectors.groupingBy(p->p.lifeCycle)));
        //第三种分类方式 //自定义返回集合类型
        System.out.println(Arrays.stream(garden)
                .collect(Collectors.groupingBy(
                        p->p.lifeCycle,
                        ()-> new EnumMap<>(LifeCycle.class),
                        Collectors.toSet()
                )));



    }


}
