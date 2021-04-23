package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.blackjack.model.DeckVO;

public class PlayerService {
	// 각 플레이어(딜러포함)가 받은 카드를 저장할 List
	List<DeckVO> myDeckList;
	Scanner scan = new Scanner(System.in);
	DeckServiceV1 dS = new DeckServiceV1();
	// deck에서 한장씩 플레이어에게 전달할 카드들, 공용카드덱
	List<DeckVO> pubDeckList;
	String playerName;
	List<DeckVO> deckList;

	// 플레이어 이름이 없는 상태로 생성이 되면 이것을 "딜러"로 사용
	public PlayerService(List<DeckVO> deckList) {

		this(deckList, "딜러");
	}

	// 플레이어로 사용하는 경우 이 생성자를 호출
	public PlayerService(List<DeckVO> deckList, String playName) {
		this.myDeckList = new ArrayList<DeckVO>();
		this.pubDeckList = deckList;
		this.playerName = playName;
	}

	// 자신이 받은 카드의 점수를 계산하는 method
	public int sumValue() {
		// 받은 카드의 리스트를 vo에 대입할때마다
		int sumValue = 0;
		for (DeckVO vo : myDeckList) {
			// vo의 getValue() method의 합을 sumValue 변수에 누적
			sumValue += vo.getValue();
		}
		return sumValue;
	}

	// 각 플레이어들이 hit를 했을때 수행할 method
	public void hit() {
		// playerName이 "딜러" 이고 점수계산의 합이 16점이 넘으면,
		if (this.playerName.equals("딜러") && this.sumValue() > 16) {
			System.out.println("딜러점수 : " + this.sumValue());
			System.out.println("딜러 Hit 금지!!");
		} else {
			// 아니면 받은카드를 카드 리스트에 추가(내 카드리스트에 pubDeckList의 0번째 카드를 더함)
			myDeckList.add(pubDeckList.get(0));

			// 받을 카드에서 0번째 한장 제외
			pubDeckList.remove(0);
		}

		System.out.println("=".repeat(50));
		System.out.println(playerName);
		System.out.println("-".repeat(50));

		// 현재 보유중인 카드 리스트를 보여주기
		for (DeckVO vo : myDeckList) {
			System.out.println(vo);
		}
		System.out.println("-".repeat(50));
		System.out.println("현재점수 : " + this.sumValue());

	}

	public void playGame() {
		dS.makeDeck();
		deckList = dS.getDeck();
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
				if (게이머.sumValue() > 21) {
					System.out.println("게이머 패!!");
					break;
				} else if (게이머.sumValue() == 21) {
					System.out.println("Blackjack 게이머 승!!");
					break;
				}
				continue;
			} else if (selectNum == 2) {
				System.out.println("게이머의 턴이 끝났습니다");
			}
			for (int i = 0; i < 17; i++) {
				if (딜러.sumValue() <= i) {
					System.out.println("딜러가 한장을 더 뽑습니다");
					딜러.hit();
				}
			}

			if (딜러.sumValue() > 21) {
				System.out.println("딜러의 턴이 끝났습니다");
				System.out.println("딜러 패!!");
				break;
			} else if (딜러.sumValue() == 21) {
				System.out.println("Blackjack 딜러 승!!");
				break;
			}else if (딜러.sumValue() == 게이머.sumValue()) {
				System.out.println("비겼습니다");
				break;
			}
			if (딜러.sumValue() > 16 && 딜러.sumValue() < 22) {
				if (딜러.sumValue() > 게이머.sumValue()) {
					System.out.println("딜러가 이겼습니다");
					break;
				} else if (딜러.sumValue() < 게이머.sumValue()) {
					System.out.println("게이머가 이겼습니다");
					break;
				}
				break;
			}
			
		}

	}

}