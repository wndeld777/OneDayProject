package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.blackjack.model.DeckVO;

public class PlayerService {
	// 각 플레이어(딜러포함)가 받은 카드를 저장할 List
	List<DeckVO> myDeckList;

	// deck에서 한장씩 플레이어에게 전달할 카드들, 공용카드덱
	List<DeckVO> pubDeckList;
	String playerName;

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
		// 받은카드를 카드 리스트에 추가(내 카드리스트에 pubDeckList의 0번째 카드를 더함)
		myDeckList.add(pubDeckList.get(0));

		// 받을 카드에서 0번째 한장 제외
		pubDeckList.remove(0);

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

	// 게임 실행
	public void playGame() {
		Scanner scan = new Scanner(System.in);
		DeckServiceV1 dS = new DeckServiceV1();
		dS.makeDeck();
		List<DeckVO> deckList = dS.getDeck();

		PlayerService 딜러 = new PlayerService(deckList);

		PlayerService 플레이어 = new PlayerService(deckList, "플레이어");

		System.out.println("=".repeat(50));
		System.out.println("게임을 시작합니다");

		딜러.hit();
		플레이어.hit();
		딜러.hit();
		플레이어.hit();

		while (딜러.sumValue() < 17) {
			딜러.hit();
			continue;
		}
		System.out.println("=".repeat(50));
		System.out.println("딜러의 턴이 끝났습니다");
		System.out.println("-".repeat(50));
		System.out.println("딜러의 점수 : " + 딜러.sumValue());
		System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
		if (딜러.sumValue() == 21) {
			System.out.println("BlackJack!!딜러 Win!!");
			return;
		} else if (딜러.sumValue() > 21) {
			System.out.println("딜러 LOSS!!");
			return;
		}

		while (true) {
			System.out.println("-".repeat(50));
			System.out.println("플레이어가 한장을 더 뽑으시겠습니까? ( YES:1 NO:2 )");
			System.out.print(">> ");
			Integer selectNum = scan.nextInt();
			if (selectNum == 1) {
				플레이어.hit();
				System.out.println();
				System.out.println("딜러의 점수 : " + 딜러.sumValue());
				System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
				if (플레이어.sumValue() == 21) {
					System.out.println("BlackJack!! 플레이어 Win!!");
					break;
				} else if (플레이어.sumValue() < 21) {
					continue;
				} else if (딜러.sumValue() > 플레이어.sumValue()) {
					System.out.println("딜러 Win!!");
					break;
				} else if (플레이어.sumValue() > 21) {
					System.out.println("딜러 Win!!");
					break;
				}
			}

			if (selectNum == 2) {
				System.out.println();
				System.out.println("딜러의 점수 : " + 딜러.sumValue());
				System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
				if (딜러.sumValue() == 플레이어.sumValue()) {
					System.out.println("딜러와 플레이어의 점수가 같습니다");
					System.out.println("무승부!!!");
					break;
				} else if (딜러.sumValue() > 플레이어.sumValue()) {
					System.out.println("딜러 Win!!");
					break;
				} else {
					System.out.println("플레이어 Win!!");
					break;
				}
			}

		} // end while
	} // end playGame

}