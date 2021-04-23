package com.callor.blackjack.model;

public class DeckVO {

	private String suit;
	private String denomination;
	private Integer value = 0;
	
	public DeckVO() {
		
	}
	public DeckVO(String suit, String denomination, Integer value) {
		super();
		this.suit = suit;
		this.denomination = denomination;
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getdenomination() {
		return denomination;
	}
	public void setdenomination(String denomination) {
		this.denomination = denomination;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return " [무늬=" + suit + ", 숫자=" + denomination + ", 점수=" + value + "]";
	}
	
}
