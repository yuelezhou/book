package com.book.effectivejava.chap6.issue38;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 18:18 2020-09-20
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public enum BasicOperation implements Operation {
    //实例实现接口，或者enum类实现接口，都可以
    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    MINUS("-"){
        @Override
        public double apply(double x, double y) {
            return x-y;
        }
    },
    TIMES("*"){
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double x, double y) {
            return x/y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }


}
