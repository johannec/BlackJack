package no.itverket;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> cardsOnHand = new ArrayList<>();
    int totalValue;

    public Hand() { }

    public boolean isBust() {
        if(this.totalValue > 21) {
            System.out.println("BUST. You got over 21 points.");
            return true;
        }
        return false;
    }
}
