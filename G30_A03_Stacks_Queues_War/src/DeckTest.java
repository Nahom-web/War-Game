import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void test() {
		Deck deck = new Deck();

		assertEquals(52, deck.size(), "Checking the size of the deck");
	}

	@Test
	void test2() {
		Deck deck = new Deck();

		String card = "2 of s";

		assertEquals(card, deck.dealCard().toString(), "Checking the top of the deck when it is not shuffled");
	}

	@Test
	void test3() {
		Deck deck = new Deck();

		String card = "2 of s";

		deck.shuffle();

		assertEquals(false, deck.dealCard().toString().equals(card),
				"Checking the top of the deck when it is shuffled, shouldn't equal the 2 of s");
	}
}