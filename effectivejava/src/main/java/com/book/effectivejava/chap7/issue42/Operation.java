package com.book.effectivejava.chap7.issue42;

import java.util.function.DoubleBinaryOperator;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 16:31 2020-09-21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public enum  Operation {

    PLUS("+",(x,y) -> x + y),
    MINUS("-",(x,y) -> x - y),
    TIMES("*",(x,y) -> x * y),
    DIVIDE("/",(x,y) -> x / y);

    private final String symbol;

    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x,double y){
        return op.applyAsDouble(x,y);
    }
}
