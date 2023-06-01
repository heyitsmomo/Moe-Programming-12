package com.moe.module23;

import java.util.Comparator;

public class SuitComp implements Comparator<Card> {

    /**
     * COMPARE EACH CARD'S SUIT
     * @param card1 the first object to be compared.
     * @param card2 the second object to be compared.
     * @return compare the suits of 2 cards
     */
    @Override
    public int compare(Card card1, Card card2) {
        return card1.getSuit().compareTo(card2.getSuit());
    }
}
