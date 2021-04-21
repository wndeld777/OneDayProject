package com.callor.blackjack.model;

public class DeckVO {

	private String suit;
	private String denomiation;
	private Integer value = 0;
	
	public DeckVO() {
		
	}
	public DeckVO(String suit, String denomiation, Integer value) {
		super();
		this.suit = suit;
		this.denomiation = denomiation;
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getDenomiation() {
		return denomiation;
	}
	public void setDenomiation(String denomiation) {
		this.denomiation = denomiation;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "DeckVO [suit=" + suit + ", denomiation=" + denomiation + ", value=" + value + "]";
	}
	
}
