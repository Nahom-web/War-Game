import java.util.ArrayDeque;
import java.util.Queue;

public class Deck {

	private String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	private String[] suits = { "Spades", "Diamonds", "Clubs", "Hearts" };
	private Integer[] values = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
	public Queue<Card> deck;

	public Deck() {
		deck = new ArrayDeque<Card>();
		createDeck();
	}

	private Queue<Card> createDeck() {
		for (int r = 0; r < ranks.length; r++) {
			for (int s = 0; s < suits.length; s++) {
				this.deck.add(new Card(ranks[r], suits[s], values[r]));
			}
		}
		return this.deck;
	}

	public Card dealCard() {
		return this.deck.poll();
	}

	public Queue<Card> shuffle() {
		Card cards[] = new Card[52];

		while (!this.deck.isEmpty()) {
			for (int i = 0; i < cards.length; i++) {
				cards[i] = this.deck.poll();
			}
		}

		for (int numCard = 0; numCard < cards.length; numCard++) {
			int currentIndex = (int) Math.ceil(Math.random() * cards.length - 1);
			Card tempCard = cards[numCard];
			cards[numCard] = cards[currentIndex];
			cards[currentIndex] = tempCard;
		}

		for (int i = 0; i < cards.length; i++) {
			this.deck.add(cards[i]);
		}

		return this.deck;
	}

	public int size() {
		return this.deck.size();
	}

}
