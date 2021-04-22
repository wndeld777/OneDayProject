/*
 * 1. 딜러와 게이머 단 2명만 있다. 
 * 
 * 2. 카드는 조커를 제외한 52장이다 카드는 
 * 		다이아몬드, 하트, 스페이드, 클럽 무늬를 가진 A,
 * 		2~10, K(킹), Q(퀸), J(잭) 으로 이루어져 있다. 
 * 
 * 3. A는 1점, 2~10은 숫자 그대로 점수를, K/Q/J는 10점으로
 * 		계산한다. (블랙잭 규칙은 A는 1과 11 둘다 가능하지만 
 * 			여기선 1만 허용하도록 한다.) 
 * 
 * 4. 딜러와 게이머는 순차적으로 카드를 하나씩
 * 		뽑아 각자 2개의 카드를 소지한다. 
 * 		게이머는 얼마든지 카드를 추가로 뽑을 수 있다. 
 * 
 * 5. 딜러는 2카드의 합계 점수가 16점 이하이면
 * 		반드시 1장을 추가로 뽑고, 17점 이상이면 추가할 수 없다. 
 * 
 * 6. 양쪽 모두 추가 뽑기 없이, 
 * 		카드를 오픈하면 딜러와 게이머 중 소유한
 * 		카드의 합이 21에 가장 가까운 쪽이 승리한다. 
 * 
 * 7. 21을 초과하면 무조건 초과한 쪽이 게임에서 진다. 
 * 
 * 8. 코드는 JAVA의 기본
 * 		JDK와 외부 LIB를 참조 할 수 있다. 
 * 
 * 9. 모든 게임은 콘솔을 통해서 진행된다. (키보드와 콘솔 출력을 구현)
 */
package com.callor.blackjack.service;

import java.util.Random;
import java.util.Scanner;

public class BlackJack05 {

	protected int p1Deck[];
	protected int p1Index;
	protected int d1Deck[];
	protected int d1Index;
	
	protected int[] deck;
	protected int deckIndex;
	protected int deckIndex1;
	protected Random rnd;
	protected Scanner scan;
	
	public BlackJack05() {
		
		p1Deck = new int[10];
		d1Deck = new int[10];
		deck = new int[52];
		deckIndex = 0;
		deckIndex1 = 0;
		rnd = new Random();
		scan = new Scanner(System.in);
	}
	
	public void createDeck() { // 1.카드생성 함수
		for (int i = 0; i < 52; i++) {
			deck[i] = i;
		}
	}
	
	public void mixDeck() { // 2.카드섞기 함수
		Random rd = new Random();
		int randNum;
		int temp;
		for (int i = 0; i < 10000; i++) {
			randNum = rd.nextInt(52);
			temp = deck[0];
			deck[0] = deck[randNum];
			deck[randNum] = temp;
		}
	}
	public void deckDisplay(int deck[], int index, String title) {
		String cardShape[] = { "스페이스", "클로버", "다이아", "하트" };
		String cardNumber[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		System.out.print(title);
		for (int i = 0; i < p1Index; i++) {
			int cardSIndex = deck[i] / cardNumber.length; // 카드 모양(cardShape) 종류 '0:스페이스/1:클로버/2:다이아/3:하트' 총 0~3의 값
			System.out.print(cardShape[cardSIndex]);
			int cardNIndex = deck[i] % cardNumber.length; // 카드 숫자(cardNumber) 종류 총 0~12의 값
			System.out.print(cardNumber[cardNIndex] + " , ");
		}
		System.out.println();
	}

	
	public void deckDisplay(int deck[], int index) { // 카드 숫자 모양 배열선언 
		
		String cardShape[] = { "스페이스", "클로버", "다이아", "하트" };
		String cardNumber[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		for (int i = 0; i < p1Index; i++) {
			int cardSIndex = deck[i] / cardNumber.length; 
			System.out.print(cardShape[cardSIndex]);
			int cardNIndex = deck[i] % cardNumber.length; 
			System.out.print(cardNumber[cardNIndex] + " , ");
		}
	}
	
	
	public void deckDisplay() {
		
		int p1Index = 0;
		boolean p1Flag = true;
		String cardShape[] = { "스페이스", "클로버", "다이아", "하트" };
		String cardNumber[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		System.out.print("p1:");
		for (int i = 0; i < p1Index; i++) {
			int cardSIndex = p1Deck[i] / cardNumber.length;
			System.out.print(cardShape[cardSIndex]);
			int cardNIndex = p1Deck[i] % cardNumber.length; 
			System.out.print(cardNumber[cardNIndex] + " , ");
		}
	}
	
	public void getp1Deck() {
			System.out.println("카드를 받겠습니까? [0=NO 1=YES]");
			Integer intP1 = scan.nextInt();
			if (intP1 == 0) { // 카드를 받지 않는 작업
				return;
			}
			if (intP1 == 1) { // 카드를 받는 작업
				p1Deck[p1Index] = deck[deckIndex];
				deckIndex++;
				p1Index++;
				
				
			}
		}
	public void getd1Deck() {
		System.out.println("카드를 받겠습니까? [0=NO 1=YES]");
		Integer intd1 = scan.nextInt();
		if (intd1 == 0) { // 카드를 받지 않는 작업
			return;
		}
		if (intd1 == 1) { // 카드를 받는 작업
			d1Deck[p1Index] = deck[deckIndex];
			deckIndex1++;
			p1Index++;
		}
	}
	public int getSum(int[] deck, int index) { // 점수 구하기 메소드
		int sum = 0;
		for (int i = 0; i < index; i++) { // A=1 J,Q,K=10으로 점수처리 한것
			int score = 0;
			score = deck[i] % 13 + 1;
			if (score > 10) {
				score = 10;
			}
			sum = sum + score;
		}
		for (int i = 0; i < index; i++) {
			if (deck[i] % 13 == 0) {
				if (sum + 10 <= 21) {
					sum = sum + 10;
				}
			}
		}
		return sum;
	}
	public void gameDisplay() { // 분배 화면 메소드
		System.out.println("");
		System.out.println(">>카드 현황");
		deckDisplay(p1Deck, p1Index, "p1: ");
		System.out.println("player 총점> " + getSum(p1Deck, p1Index));
		deckDisplay(d1Deck, d1Index, "p2: ");
		System.out.println("dealer 총점> " + getSum(d1Deck, d1Index));
		System.out.println("");
	}
	public String whoIsWin() { // 승패 메소드
		int player = getSum(p1Deck, p1Index);
		int dealer = getSum(d1Deck, d1Index);
		String playState = "";
		if (player > 21) { // 먼저 카드를 받은 p1이 진다
			playState = "dealer 승리!!!";
		} else if (dealer > 21) {
			playState = "player 승리!!!";
		} else if (player > dealer) {
			playState = "player 승리!!!";
		} else if (player == dealer) {
			playState = "무승부!!!";
		} else {
			playState = "dealer 승리!!!";
		}
		return playState;
	}
	public void main(String[] args) {
		 
        createDeck();
        
        mixDeck();
        for (int i = 0; i < 3; i++) {
            getp1Deck();
            getd1Deck();
            gameDisplay();
        }
        System.out.println("★★★★★");
        System.out.println(whoIsWin());

}
	
}