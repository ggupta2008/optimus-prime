package games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Given a hand, show the result of the game
public class Poker {


    class Deck {
        private ArrayList<Card> deck = new ArrayList<>();
        final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
        final int NUMBER_OF_CARDS_IN_STANDARD_SUIT = 13;
        final int NUMBER_OF_SUITS_IN_STANDARD_DECK = 4;
        final int NUMBER_OF_CARDS_IN_STANDARD_DECK = NUMBER_OF_CARDS_IN_STANDARD_SUIT * NUMBER_OF_SUITS_IN_STANDARD_DECK;

        public Deck() {
            for (int suit = 0; suit < NUMBER_OF_SUITS_IN_STANDARD_DECK; suit++) {
                for (int value = 1; value <= NUMBER_OF_CARDS_IN_STANDARD_SUIT; value++) {
                    deck.add(new Card(SUITS[suit], value));
                }
            }
        }

        public ArrayList<Card> getDeck() {
            return deck;
        }

        public void setDeck(ArrayList<Card> deck) {
            this.deck = deck;
        }

        public void addCard(Card card) {
            deck.add(card);
        }

        public int getSize() {
            return deck.size();
        }

        public Card dealCard() {
            return deck.remove(0);
        }

        public void shuffle() {
            Random rand = new Random();
            for (int i = 0; i < deck.size(); i++) {
                // Random for remaining positions.
                int r = i + rand.nextInt(deck.size() - i);
                //swapping the elements
                Card temp = deck.get(i);
                deck.add(r, deck.get(i));
                deck.add(i, temp);
            }

            // or do this
            Collections.shuffle(deck);
        }
    }


    class Card {
        private String suit;
        private int value;

        public Card(String suit, int value) {
            this.suit = suit;
            this.value = value;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String toString() {
            String stringValue = "";
            if (value == 11)
                stringValue = "Jack";
            else if (value == 12)
                stringValue = "Queen";
            else if (value == 13)
                stringValue = "King";
            else if (value == 1)
                stringValue = "Ace";
            else
                stringValue = String.valueOf(value);
            return stringValue + " of " + suit;
        }

    }
}
