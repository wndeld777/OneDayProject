package com.callor.blackjack.service;

import java.util.Scanner;

public class BlackJackExample {
	
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BlackJackDealer dealer = new BlackJackDealer();
		dealer.initialize();

		BlackJackHand gamersHand = new BlackJackHand();

		System.out.println("Welcome codeit CASINO!");

		int wins = 0, loses = 0;

		menu: while (true) {
			System.out.println("---------------------------------");
			dealer.printLog();
			System.out.println("---------------------------------");

			if (dealer.needsShuffle()) {
				System.out.println("Shoe needs Shuffle.");
				System.out.println("---------------------------------");

				dealer.shuffle();
			}

			System.out.println("(D)eal (S)huffle (E)xit");

			switch (scanner.next()) {
			case "D":
			case "d":
				System.out.println("---------------------------------");
				dealer.deal(gamersHand, 2);

				if (gamersHand.isBlackJack()) {
					System.out.println("[Gamer] Cards");
					gamersHand.print();

					System.out.println("BLACKJACK!! You Win!");
					System.out.println("---------------------------------");

					wins++;

					dealer.returnHand(gamersHand);

					break;
				}

				dealer.dealSelf();

				game: while (true) {
					BlackJackCard openCard = dealer.getDealersOpenCard();
					System.out.println("[Dealer] Open Card");
					System.out.println(openCard);
					System.out.println("Value: " + openCard.getValue());
					System.out.println("---------------------------------");
					System.out.println("[Gamer] Cards");
					gamersHand.print();

					if (gamersHand.isBusted()) {
						System.out.println("---------------------------------");
						System.out.println("[Result] Gamer Busted. Gamer Loses.");
						System.out.println("---------------------------------");

						loses++;

						dealer.returnHand(gamersHand);
						dealer.returnDealersHand();

						break game;
					}

					System.out.println("---------------------------------");
					System.out.println(("(H)it (S)tay"));
					switch (scanner.next()) {
					case "H":
					case "h":
						System.out.println("---------------------------------");
						dealer.hit(gamersHand);

						break;

					case "S":
					case "s":
						System.out.println("---------------------------------");

						System.out.println("Dealer's Hand - Value: " + dealer.getDealersHandValue());
						dealer.printDealersHand();
						System.out.println("---------------------------------");
						System.out.println("Gamer's Hand - Value: " + gamersHand.getValue());
						gamersHand.print();

						System.out.println("---------------------------------");

						dealer.returnHand(gamersHand);
						dealer.returnDealersHand();
						switch (dealer.showdown(gamersHand)) {
						case BlackJackDealer.RESULT_DEALER_BUSTED:
							wins++;
							System.out.println("[Result] Dealer Busted. Gamer wins.");

							break;

						case BlackJackDealer.RESULT_DEALER_WINS:
							loses++;
							System.out.println("[Result] Gamer Loses");

							break;

						case BlackJackDealer.RESULT_GAMER_WINS:
						case BlackJackDealer.RESULT_DRAW:
							wins++;

							System.out.println("[Result] Gamer Wins!");
							break;
						}

						System.out.println("---------------------------------");

						break game;
					}
				}

				System.out.println("Played " + (wins + loses) + " games. wins: " + wins + ", loses: " + loses + "");

				break;

			case "S":
			case "s":
				System.out.println("---------------------------------");
				dealer.shuffle();
				System.out.println("Shuffled.");

				break;

			case "E":
			case "e":
				System.out.println("---------------------------------");
				break menu;
			}
		}

		System.out.println("Nice Game!:)");
	}
}
