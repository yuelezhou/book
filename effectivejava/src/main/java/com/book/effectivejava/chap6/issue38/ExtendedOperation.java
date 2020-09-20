package com.book.effectivejava.chap6.issue38;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 18:22 2020-09-20
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public enum ExtendedOperation implements Operation {
    EXP("^"){
        @Override
        public double apply(double x, double y) {
            return Math.pow(x,y);
        }
    },
    REMAINDER("%"){
        @Override
        public double apply(double x, double y) {
            return x%y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
