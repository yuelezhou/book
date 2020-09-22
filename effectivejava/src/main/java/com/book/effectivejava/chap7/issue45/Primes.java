package com.book.effectivejava.chap7.issue45;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 15:18 2020-09-22
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class Primes {
    static Stream<BigInteger> primes(){
        return Stream.iterate(TWO,BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
        primes().map(p->TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(50L)
               // .forEach(System.out::println);
                .forEach(mp->System.out.println(mp.bitLength() + ":" + mp));
    }
}
