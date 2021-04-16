package com.callor.blackjack.service;
public class BlackJackHand extends Deck {

	@Override
	public void print() {
		super.print();

		System.out.println("Value: " + getValue());
	}

	public int getValue() {
		int value = 0;
		int aceCount = 0;

		for (Card c : getCards()) {
			BlackJackCard card = (BlackJackCard) c;
			if (card.isAce()) {
				aceCount++;
			}

			value += card.getValue();
		}

		while (aceCount > 0 && value > 21) {
			aceCount--;
			value -= 10;
		}

		return value;
	}

	public boolean isBusted() {
		return getValue() > 21;
	}

	public boolean isBlackJack() {
		return getValue() == 21 && getCards().size() == 2;
	}
}