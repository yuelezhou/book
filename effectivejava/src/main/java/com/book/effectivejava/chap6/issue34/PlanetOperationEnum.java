package com.book.effectivejava.chap6.issue34;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 11:39 2020-09-20
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public enum PlanetOperationEnum {
//    第一种 添加了新的常量
//    PLUS,MINUS,TIMES,DIVIDE;
//    public double apply(double x,double y){
//        switch (this){
//            case PLUS: return x+y;
//            case MINUS: return x-y;
//            case TIMES: return x*y;
//            case DIVIDE: return x/y;
//        }
//        throw new AssertionError("Unknown op:" + this);
//    }
    PLUS{
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    MINUS{
        @Override
        public double apply(double x, double y) {
            return x-y;
        }
    },
    TIMES{
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE{
        @Override
        public double apply(double x, double y) {
            return 0;
        }
    };

    public abstract double apply(double x,double y);


}
