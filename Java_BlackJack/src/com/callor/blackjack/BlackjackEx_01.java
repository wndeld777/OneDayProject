package com.callor.blackjack;

import com.callor.blackjack.service.DeckServiceV1;

public class BlackjackEx_01 {

	public static void main(String[] args) {
		
		DeckServiceV1 dsV1 = new DeckServiceV1();
		dsV1.getDeck();
		dsV1.makeDeck();
	}
}
