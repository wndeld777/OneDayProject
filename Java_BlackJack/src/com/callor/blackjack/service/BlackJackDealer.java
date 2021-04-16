import java.util.ArrayList;

public class BlackJackDealer extends Deck {
	public static final int NUMBER_OF_DECKS = 4;
	public static final double RESHUFFLE_RATE = 0.2;
	public static final int DEALER_STANDS_ON = 17;

	public static final int RESULT_DEALER_BUSTED = 1;
	public static final int RESULT_DEALER_WINS = 2;
	public static final int RESULT_GAMER_WINS = 3;
	public static final int RESULT_DRAW = 4;

	private ArrayList<Card> returned = new ArrayList<>();
	private BlackJackHand hand = new BlackJackHand();

	@Override
	public void shuffle() {
		cards.addAll(returned);
		returned.clear();

		super.shuffle();
	}

	public void initialize() {
		for (int deck = 0; deck < NUMBER_OF_DECKS; deck++) {
			for (int suit = 1; suit <= 4; suit++) {
				for (int rank = 1; rank <= 13; rank++) {
					BlackJackCard newCard = new BlackJackCard(suit, rank);
					addCard(newCard);
				}
			}
		}

		super.shuffle();
	}

	public void dealSelf() {
		deal(hand, 2);
	}

	public BlackJackCard getDealersOpenCard() {
		if (!hand.cards.isEmpty()) {
			return (BlackJackCard) hand.cards.get(0);
		}

		return null;
	}

	public void printDealersHand() {
		hand.print();
	}

	public int getDealersHandValue() {
		return hand.getValue();
	}

	public int showdown(BlackJackHand gamers) {
		while (hand.getValue() < DEALER_STANDS_ON) {
			hit(hand);
		}

		if (hand.isBusted()) {
			return RESULT_DEALER_BUSTED;
		} else if (gamers.getValue() == hand.getValue()) {
			return RESULT_DRAW;
		} else if (gamers.getValue() > hand.getValue()) {
			return RESULT_GAMER_WINS;
		} else {
			return RESULT_DEALER_WINS;
		}
	}

	public void hit(BlackJackHand hand) {
		hand.addCard(cards.remove(0));
	}

	public void returnHand(BlackJackHand gamers) {
		returned.addAll(gamers.cards);
		gamers.cards.clear();
	}

	public void returnDealersHand() {
		returnHand(hand);
	}

	public boolean needsShuffle() {
		return getRemainRate() < RESHUFFLE_RATE;
	}

	public void printLog() {
		System.out.println("[LOG] # of cards in returned: " + returned.size());
		System.out.println("[LOG] # of cards in shoe: " + cards.size());
		System.out.println("[LOG] Remain rate: " + getRemainRate());
	}

	private double getRemainRate() {
		return (double) cards.size() / (NUMBER_OF_DECKS * Card.NUMBER_OF_CARDS_IN_A_DECK);
	}
}