package day02;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Deck {

    public static final String[] SUITS = {
            "Diamond", "Spade", "Heart", "Club"
    };
    public static final String[] NAMES = {
            "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Jack", "Queen", "King"
    };
    public static final int[] VALUES = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            10, 10, 10
    };

    protected List<Card> cards = new ArrayList<>();

    public Deck() {

        for (int s = 0; s < SUITS.length; s++) {
            String suit = SUITS[s];
            for (int n = 0; n < NAMES.length; n++) {
                String name = NAMES[n];
                int value = VALUES[n];
                Card card = new Card(suit, name, value);
                cards.add(card);
            }
        }

    }

    public Card get() {
        return this.get(0);
    }

    public Card get(int pos) {
        return this.cards.get(pos);
    }

    public Deck shuffleDeck() {

        Random rand = new Random();

        for(int i = this.cards.size() - 1; i > 0 ;i--) {
            int j = rand.nextInt(this.cards.size());
            Card temp = this.cards.get(i);
            this.cards.set(i, this.cards.get(j));
            this.cards.set(j, temp);
        }

        return this;
        
    }

    @Override
    public String toString() {
        return "number of cards: %d".formatted(cards.size());
    }

}
