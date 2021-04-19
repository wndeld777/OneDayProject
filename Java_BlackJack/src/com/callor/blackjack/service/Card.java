package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.callor.blackjack.model.CardVO;

public class Card {

	protected List<CardVO> cardList;
	protected Random rnd;
	public Card() {
		cardList = new ArrayList<CardVO>();
		rnd = new Random();
	}
	
	public void inputCard() {
		String patterns[] = {"spade","heart","diamond","club"};
		String card[] = {"2","3","4","5","6","7","8","9","10","Ace","Jack","Queen","King"};
		
		
		for(int i = 0 ; i < patterns.length ; i++) {
			for(int j = 0 ; j < card.length ; j++) {
				System.out.print(patterns[i]);
				System.out.println(card[j]);
			}
		}
	}
	
	
	
	
}
