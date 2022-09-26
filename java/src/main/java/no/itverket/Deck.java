package no.itverket;

import java.util.*;

class Deck {
    List<Card> cards;

    Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                cards.add(new Card(suit, i));
            }
        }

        Collections.shuffle(this.cards);
    }
}
