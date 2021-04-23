package com.callor.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.callor.blackjack.model.DeckVO;
import com.callor.blackjack.service.PlayerService;

public class BlackJack {

	public static void main(String[] args) {
		List<DeckVO> deckList = new ArrayList<DeckVO>();
		
		PlayerService ps = new PlayerService(deckList);
		ps.playGame();
	}
}