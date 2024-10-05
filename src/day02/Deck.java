package day02;

import java.util.Random;

public class Deck {

    public static final String[] SUITS = {
        "Diamond", "Spade", "Heart", "Club"
    };
    public static final String[] NAMES = {
        "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Jack", "Queen", "King"
    };
    public static final int[] VALUES = {
        1,2,3,4,5,6,7,8,9,10,
        10,10,10
    };

    protected Card[] cards; // CHange to list

    public Deck() {

        cards = new Card[52]; // Change to list
        int idx = 0;

        for(int s = 0; s < SUITS.length; s++) {
            String suit = SUITS[s];
            for (int n = 0; n < NAMES.length; n++) {
                String name = NAMES[n];
                int value = VALUES[n];
                Card card = new Card(suit,name,value);
                cards[idx] = card;
                idx++;
            }
        }

    }

    public Card get() {
        return this.get(0);
    }

    public Card get(int pos) {
        return this.cards[pos];
    }

    public Deck shuffleDeck() {

        Random rand = new Random();

        for(int i = this.cards.length - 1; i > 0 ;i--) {
            int j = rand.nextInt(this.cards.length);
            Card temp = this.cards[i];
            this.cards[i] = this.cards[j];
            this.cards[j] = temp;
        }

        return this;
        
    }

    @Override
    public String toString() {
        return "number of cards: %d".formatted(cards.length);
    }
    
}
