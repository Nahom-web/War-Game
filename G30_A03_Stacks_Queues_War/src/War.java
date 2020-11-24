import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class War {

	protected Queue<Card> pile1;
	protected Queue<Card> pile2;
	private Player player1;
	private Player player2;
	public ArrayList<Player> players;
	public ArrayList<Card> kitty;

	public War() {
		pile1 = new ArrayDeque<Card>();
		pile2 = new ArrayDeque<Card>();
		players = new ArrayList<Player>();
		kitty = new ArrayList<Card>();
	}	

	public Queue<Card> getPile1() {
		return pile1;
	}

	public void setPile1(Queue<Card> pile1) {
		this.pile1 = pile1;
	}

	public Queue<Card> getPile2() {
		return pile2;
	}

	public void setPile2(Queue<Card> pile2) {
		this.pile2 = pile2;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Card> getKitty() {
		return kitty;
	}

	public void setKitty(ArrayList<Card> kitty) {
		this.kitty = kitty;
	}

	public ArrayList<Player> start() {
		Deck deck = new Deck();
		deck.shuffle();

		while (!deck.deck.isEmpty()) {
			pile1.add(deck.dealCard());
			pile2.add(deck.dealCard());
		}

		player1 = new Player("Nahom", pile1);
		player2 = new Player("Ibrahim", pile2);

		players.add(player1);
		players.add(player2);

		return players;
	}

	public ArrayList<Player> play() {
		for (int i = 0; i < this.players.size(); i++) {
			this.players.get(i).setWonCurrentGame(false);
			this.players.get(i).setWarGame(false);
			this.players.get(i).setCurrentCard(this.players.get(i).getCards().poll());
		}

		int winner = this.players.get(0).getCurrentCard().compareTo(this.players.get(1).getCurrentCard());

		switch (winner) {
		case 1:
			addCardToHand(this.players.get(0), this.players.get(1).getCurrentCard());
			addKittyToHand(this.players.get(0));
			break;
		case -1:
			addCardToHand(this.players.get(1), this.players.get(0).getCurrentCard());
			addKittyToHand(this.players.get(1));
			break;
		case 0:
			playWar(this.players.get(0).getCurrentCard(), this.players.get(1).getCurrentCard());
			break;
		}

		return this.players;
	}

	private void addKittyToHand(Player player) {
		if (kitty.size() >= 1) {
			for (int i = 0; i < kitty.size(); i++) {
				player.getCards().add(kitty.get(i));
			}
			kitty.clear();
		}
	}

	private void addCardToHand(Player player, Card card) {
		player.getCards().add(player.getCurrentCard());
		player.getCards().add(card);
		player.setWonCurrentGame(true);
	}

	public boolean isGameOver() {
		for (int i = 0; i < this.players.size(); i++) {
			if (this.players.get(i).getCards().size() == 0) {
				return true;
			}
		}
		return false;
	}

	public Player getWinner() {
		if (this.players.get(0).getCards().size() > this.players.get(1).getCards().size())
			return player1;
		else
			return player2;
	}

	protected void playWar(Card card, Card card2) {
		Player p1 = this.players.get(0);
		Player p2 = this.players.get(1);

		p2.setWarGame(true);

		kitty.add(card);
		kitty.add(card2);

		for (int i = 0; i < 3; i++) {
			kitty.add(p1.getCards().poll());
			kitty.add(p2.getCards().poll());
		}
	}

} // War class