package com.callor.blackjack;

import java.util.List;
import java.util.Scanner;

import com.callor.blackjack.model.DeckVO;
import com.callor.blackjack.service.DeckServiceV1;
import com.callor.blackjack.service.PlayerService;

public class GameStart {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		DeckServiceV1 dS = new DeckServiceV1();
		dS.makeDeck();
		List<DeckVO> deckList = dS.getDeck();

		PlayerService 딜러 = new PlayerService(deckList);

		PlayerService 게이머 = new PlayerService(deckList, "게이머");

		System.out.println("=".repeat(50));
		System.out.println("게임을 시작합니다");

		딜러.hit();
		게이머.hit();

		딜러.hit();
		게이머.hit();

		System.out.println("-".repeat(50));
		System.out.println("딜러의 점수 : " + 딜러.sumValue());
		System.out.println("게이머의 점수 : " + 게이머.sumValue());
		while (true) {
			System.out.println("게이머가 한장을 더 뽑으시겠습니까? ( YES:1 NO:2 )");
			System.out.print(">> ");
			Integer selectNum = scan.nextInt();
			if (selectNum == 1) {
				게이머.hit();
				continue;
			} else if (selectNum == 2) {
				System.out.println("게이머의 턴이 끝났습니다");
				if (딜러.sumValue() <= 16) {
					System.out.println("딜러가 한장을 더 뽑습니다");
					딜러.hit();
					continue;
				}
			}
			if (딜러.sumValue() > 17 || 딜러.sumValue() <= 21) {
				System.out.println("딜러의 턴이 끝났습니다");
				if (딜러.sumValue() > 게이머.sumValue()) {
					System.out.println("딜러가 이겼습니다");
					break;
				} else if (딜러.sumValue() < 게이머.sumValue()) {
					System.out.println("게이머가 이겼습니다");
					break;
				} else if (딜러.sumValue() == 게이머.sumValue()) {
					System.out.println("비겼습니다");
					break;
				}
			}else if(딜러.sumValue() == 21){
				System.out.println("딜러 BlackJack!!");
			}else {
				System.out.println("딜러가 점수범위를 벗어나 졌습니다");
			}

		}

	}
}