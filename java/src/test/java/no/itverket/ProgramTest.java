package no.itverket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProgramTest {

    private Deck deck;
    Hand hand;


    @Before
    public void setUp() {
        deck = new Deck();
        hand = new Hand();
    }

    @Test
    public void shouldHave52Cards() {
        Assert.assertEquals(52, deck.cards.size());
    }

    @Test
    public void shouldHave4DistinctSuits() {
        Assert.assertEquals(4, deck.cards.stream().map(c -> c.suit).distinct().count());
    }

    @Test
    public void givenValuesOver21_whenHit_shouldBustAndStopTheGame() {
        while(hand.totalValue < 22) {
            Program.hit(deck, hand);
        }

        Assert.assertTrue(hand.isBust());
    }

    @Test
    public void givenValuesUnder22_shouldNotBust() {
        hand.totalValue = 21;

        Assert.assertFalse(hand.isBust());
    }


}