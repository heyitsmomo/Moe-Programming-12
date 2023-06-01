package com.moe.module23;

import java.util.Comparator;

public class FaceCardComp implements Comparator<Card> {

    /**
     * COMPARE THE CARDS
     * @param card1 the first object to be compared.
     * @param card2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Card card1, Card card2) {
        boolean isFaceCard1 = isFaceCard(card1);
        boolean isFaceCard2 = isFaceCard(card2);

        if(isFaceCard1 && !isFaceCard2) {
            return -1;
        } else if(!isFaceCard1 && isFaceCard2) {
            return 1;
        } else {
            return card1.getNum() - card2.getNum();
        }
    }

    /**
     * CHECK IF CARD IS A FACE CARD
     * @param card a Card in the deck
     * @return if card number is between 11 and 13
     */
    private boolean isFaceCard(Card card) {
        int num = card.getNum();
        return num >= 11 && num <= 13;
    }
}
