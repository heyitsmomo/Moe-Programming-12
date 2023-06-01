package com.moe.module23;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    /**
     * CREATE DECK OF CARDS
     * @return the deck of cards
     */
    public LinkedList<Card> Deck() {
        LinkedList<Card> deck = new LinkedList<>();
        for(Suit suit : Suit.values()) {
            for(int num = 1; num <= 13; num++) {
                String position;
                if(num == 1) {
                    position = "Ace";
                } else if(num == 11) {
                    position = "Jack";
                } else if(num == 12) {
                    position = "Queen";
                } else if(num == 13) {
                    position = "King";
                } else {
                    position = String.valueOf(num);
                }
                deck.add(new Card(suit, position, num));
            }
        }
        return deck;
    }

    /**
     * CREATE PULLED CARDS
     * @param deck the deck of cards
     * @param cardNum Number of pulled cards
     * @return pulled cards
     */
    public LinkedList<Card> pull(LinkedList<Card> deck, int cardNum) {
        LinkedList<Card> pull = new LinkedList<>();
        Random random = new Random();
        for(int i = 0; i < cardNum; i++) {
            int randomIndex = random.nextInt(deck.size());
            Card drawnCard = deck.remove(randomIndex);
            pull.add(drawnCard);
        }
        return pull;
    }

    /**
     * PRINT THE DECK OF CARDS
     * @param deck the deck of cards
     */
    public void printDeck(LinkedList<Card> deck) {
        Iterator<Card> iterator = deck.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * PRINT PULLED CARDS
     * @param pull the pulled cards
     */
    public void printPull(LinkedList<Card> pull) {
        Iterator<Card> iterator = pull.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * MAIN METHOD
     * @param args not used
     */
    public static void main(String[] args) {
        Main main = new Main();
        LinkedList<Card> deck = main.Deck();
        System.out.println("Deck of Cards: ");
        main.printDeck(deck);

        System.out.println();
        System.out.println("Pulled 7 Cards: ");
        LinkedList<Card> pull = main.pull(deck, 7);
        main.printPull(pull);

        Collections.sort(deck, new SuitComp());
        System.out.println("Sorted by suit:");
        main.printDeck(deck);

        Collections.sort(deck, new FaceCardComp());
        System.out.println("Sorted by face card or not: ");
        main.printDeck(deck);

    }
}
