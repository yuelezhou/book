package com.book.effectivejava.chap6.issue37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 17:40 2020-09-20
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public enum Phase {
    SOLID,LIQUID,GAS;

    public enum Transition {
        MELT(SOLID,LIQUID),FREEZE(LIQUID,SOLID),
        BOIL(LIQUID,GAS),CONDENSE(GAS,LIQUID),SUBLIME(SOLID,GAS),
        DEPOSIT(GAS,SOLID),TEST(GAS,LIQUID),TEST1(GAS,LIQUID);


        private final Phase from;

        private final Phase to;

        Transition(Phase from,Phase to){
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase,Transition>> m =
                Stream.of(values()).collect(Collectors.groupingBy(t -> t.from,
                        ()->new EnumMap<>(Phase.class),
                        Collectors.toMap(t->t.to,
                                t->t,
                                (x,y)-> y,
                                ()-> new EnumMap<>(Phase.class))));

        public static Transition from(Phase from,Phase to){
            return m.get(from).get(to);
        }

    }

    public static void main(String[] args) {
        System.out.println(Transition.m);
        System.out.println(Transition.from(Phase.SOLID,Phase.LIQUID));
    }


}
