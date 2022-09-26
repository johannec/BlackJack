package no.itverket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        final Deck deck = new Deck();
        Hand hand = new Hand();
        boolean bust = false;
        boolean stopProgram = false;

        final Scanner scanner = new Scanner(System.in);

        while (!bust && !stopProgram) {
            System.out.println("Stand, Hit");
            final String read = scanner.nextLine();

            switch (read) {
                case "Hit":
                case "hit":
                case "h":
                    hit(deck, hand);
                    break;
                case "Stand":
                case "stand":
                case "s":
                    stopProgram = true;
                    break;
            }

            bust = hand.isBust();
        }
    }



    public static void hit(Deck deck, Hand hand) {
        final Card card = deck.cards.remove(0);
        hand.cardsOnHand.add(card);
        hand.totalValue = hand.cardsOnHand.stream().map(x -> Math.min(x.rank, 10)).reduce(0, Integer::sum);
        System.out.println(String.format("Hit with %s %s. Total is %s", card.suit, card.rank, hand.totalValue));
    }
}
