package War;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class WarTest {

	@Test
	void test() {
		War war = new War();

		ArrayList<Player> players = war.start();

		players.get(0).setCurrentCard(new Card("2", "spades", 2));
		players.get(1).setCurrentCard(new Card("7", "spades", 7));

		int winner = players.get(0).getCurrentCard().compareTo(players.get(1).getCurrentCard());

		assertEquals(-1, winner, "Testing which card won");
	}

	@Test
	void test2() {
		War war = new War();

		ArrayList<Player> players = war.start();

		players.get(0).setCurrentCard(new Card("7", "spades", 7));
		players.get(1).setCurrentCard(new Card("2", "spades", 2));

		int winner = players.get(0).getCurrentCard().compareTo(players.get(1).getCurrentCard());

		assertEquals(1, winner, "Testing which card won");
	}

	@Test
	void test3() {
		War war = new War();

		ArrayList<Player> players = war.start();

		players.get(0).setCurrentCard(new Card("king", "diamonds", 13));
		players.get(1).setCurrentCard(new Card("kind", "spades", 13));

		int winner = players.get(0).getCurrentCard().compareTo(players.get(1).getCurrentCard());

		assertEquals(0, winner, "Testing which card won");
	}

	@Test
	void test4() {
		Deck deck = new Deck();

		War war = new War();

		war.start();

		assertEquals(26, war.pile1.size(), "Checking player 1 hand size");

		assertEquals(26, war.pile2.size(), "Checking player 2 hand size");
	}
	
	@Test
	void test5() {
		Deck deck = new Deck();

		War war = new War();

		ArrayList<Player> players = war.start();
		
		players.get(0).setCurrentCard(new Card("king", "diamonds", 13));
		
		players.get(1).setCurrentCard(new Card("kind", "spades", 13));
		
		war.playWar(players.get(0).getCurrentCard(), players.get(1).getCurrentCard());
		
		assertEquals(8, war.kitty.size(), "Checking the kitty size");
	
	}

}
