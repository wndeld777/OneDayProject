package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.callor.blackjack.model.CardVO;

public class Card {

	protected List<String> dealerList;
	protected List<String> userList;
	protected Random rnd;

	public Card() {
		dealerList = new ArrayList<String>();
		userList = new ArrayList<String>();
		rnd = new Random();
	}

	public void inputCard() {
		String patterns[] = { "♠", "♥", "◆", "♣" };
		String card[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "Queen", "King" };

		for (int i = 0; i < patterns.length; i++) {
			for (int j = 0; j < card.length; j++) {
				String cardScore = patterns[i] + card[j];
				
			}
		}
	}
	protected int getDealersValue(int dValue) {
        dValue = 0;

        for(int i = 0; i < dealerList.size(); i++) {
            if(dealerList.get(i).equals("2")) {
                dValue += 2;
            } else if(dealerList.get(i).equals("3")) {
                dValue += 3;
            } else if(dealerList.get(i).equals("4")) {
                dValue += 4;
            } else if(dealerList.get(i).equals("5")) {
                dValue += 5;
            } else if(dealerList.get(i).equals("6")) {
                dValue += 6;
            } else if(dealerList.get(i).equals("7")) {
                dValue += 7;
            } else if(dealerList.get(i).equals("8")) {
                dValue += 8;
            } else if(dealerList.get(i).equals("9")) {
                dValue += 9;
            } else if(dealerList.get(i).equals("10")) {
                dValue += 10;
            } else if(dealerList.get(i).equals("Jack")) {
                dValue += 10;
            } else if(dealerList.get(i).equals("Queen")) {
                dValue += 10;
            } else if(dealerList.get(i).equals("King")) {
                dValue += 10;
            } else if(dealerList.get(i).equals("Ace")) {
                dValue += 11;
            }
        }
        return dValue;
    }
}
