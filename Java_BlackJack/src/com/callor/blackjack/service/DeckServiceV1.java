package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.callor.blackjack.model.DeckVO;

public class DeckServiceV1 {
	Random rnd;
	protected List<DeckVO> deckList;
	String strSuit = "다이아(◆):하트(♡):스페(♠):클로버(♣)";
	String strDenomi = "A234567890KQJ";
	
	public DeckServiceV1() {
		deckList = new ArrayList<DeckVO>();
		rnd = new Random();
	}
	
	public DeckVO getDeck() {
		int nSize = deckList.size();
		int deckIndex = rnd.nextInt(nSize);

		DeckVO retDeckVO = deckList.get(deckIndex);
		deckList.remove(deckIndex);
		return retDeckVO;
		
	}
	
	public void makeDeck() {
		String[] denoms = strDenomi.split("");
		String[] suits = strSuit.split(":");
		
		// 4번 반복
		for(String suit : suits) {
			for(String denom : denoms) {
				
				Integer intValue = 0;
				
				try {
					intValue = Integer.valueOf(denom);
					if(intValue == 0) intValue = 10;
				} catch (NumberFormatException e) {
					// denom 문자열이 A,K,Q,J인경우 Exception
					if(denom.equals("A")) intValue = 1;
					else intValue = 10;
				}
				
				DeckVO deckVO = new DeckVO();
				deckVO.setSuit(suit);
				deckVO.setDenomiation(denom);
				deckVO.setValue(intValue);
				deckList.add(deckVO);
				System.out.println(deckVO);
			}
		}
		
	}
	
	public void userDeck() {
		
	}
}