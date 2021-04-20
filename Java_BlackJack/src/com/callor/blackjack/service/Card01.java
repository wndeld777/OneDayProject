package com.callor.blackjack.service;

import java.util.Random;

public class Card01 {
	protected String[] Card = new String[12];
	protected String[] patterns = {"D", "H", "S", "C"};

	public Card01() {

	}

	public void setCard() {
		Card[0] = "A";
		Card[1] = "2";
		Card[2] = "3";
		Card[3] = "4";
		Card[4] = "5";
		Card[5] = "6";
		Card[6] = "7";
		Card[7] = "8";
		Card[8] = "9";
		Card[9] = "10";
		Card[10] = "J";
		Card[11] = "Q";
		Card[12] = "K";

		Random rnd = new Random();
		Integer cardSign = Integer.valueOf(Card[13]);
		
		Integer cardSign1 = rnd.nextInt(cardSign);
		if(cardSign.equals("A")) {
			cardSign = 1;
		}
		Integer suit = Integer.valueOf(patterns[3]);
		Integer Suit1 = rnd.nextInt(suit);
		System.out.print(cardSign1 + Suit1);
	}
}
