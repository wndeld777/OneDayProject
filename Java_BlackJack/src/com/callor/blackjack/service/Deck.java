package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.Random;

import javax.smartcardio.Card;

public class Deck {
	protected ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void print() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public void shuffle() {
        Random random = new Random();

        for (int i = 0; i < cards.size(); i++) {
            int randIndex = random.nextInt(cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randIndex));
            cards.set(randIndex, temp);
        }
    }

    public void deal(Deck hand, int count) {
        for (int i = 0; i < count; i++) {
            if (cards.size() < 1)
                break;

            hand.cards.add(cards.remove(0));
        }
    }
}
