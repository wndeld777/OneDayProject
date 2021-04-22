package com.callor.blackjack;

import com.callor.blackjack.service.BlackJack05;

public class BlackjackEx_05 {

	public static void main(String[] args) {
		
		BlackJack05 bj05 = new BlackJack05();
		bj05.createDeck();
		bj05.mixDeck();
		bj05.deckDisplay();
		bj05.getp1Deck();
		bj05.getd1Deck();
		bj05.whoIsWin();
		bj05.gameDisplay();
	}
}
