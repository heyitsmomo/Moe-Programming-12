package com.moe.module22;

public class Card {
    private Suit suit;
    private String position;
    private int num;

    /**
     * CARD CONSTRUCTOR
     * @param suit the suit of card
     * @param position the position (ex. jack, queen, king, ace, or just a number)
     * @param num the numerical value of card
     */
    public Card(Suit suit, String position, int num) {
        this.suit = suit;
        this.position = position;
        this.num = num;
    }

    /**
     * GET SUIT
     * @return the suit of card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * GET POSITION
     * @return the position (ex. jack, queen, king, ace, or just a number)
     */
    public String getPosition() {
        return position;
    }

    /**
     * GET NUMERICAL VALUE
     * @return the numerical value of the card
     */
    public int getNum() {
        return num;
    }

    /**
     * OVERALL RESULT TO STRING
     * @return
     */
    public String toString() {
        return position + " of " + suit;
    }
}
