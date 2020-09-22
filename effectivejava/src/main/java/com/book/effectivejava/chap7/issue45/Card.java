package com.book.effectivejava.chap7.issue45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ Author     ：zhoule
 * @ Date       ：Created in 15:53 2020-09-22
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class Card {

    private final Suit suit;

    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    private enum Suit {
        One,Two,Three,Four;
    }

    private enum Rank {
        Heart,Square;
    }

    private static List<Card> newDeck(){
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                result.add(new Card(suit,rank));
        return result;
    }

    private static List<Card> newDeck2(){
        return Stream.of(Rank.values()).flatMap(rank ->
                Stream.of(Suit.values()).map(suit -> new Card(suit,rank)))
                .collect(Collectors.toList());
    }





}
