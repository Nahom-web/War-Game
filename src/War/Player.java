package War;

/**Title: Player class
 * Description: This class creates a new Player with their name and their hand of cards 
 * Copyright: Copyright (c) 2020
 * Company: Heritage College
 * @author Nahom Haile
 * @version 1.0
 ***/

import java.util.Queue;

public class Player {

	private String name;
	public Queue<Card> cards;
	public Card currentCard;
	public boolean wonCurrentGame;
	public boolean isWarGame;

	public Player(String n, Queue<Card> c) {
		this.name = n;
		this.cards = c;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Queue<Card> getCards() {
		return cards;
	}

	public void setCards(Queue<Card> cards) {
		this.cards = cards;
	}

	public Card getCurrentCard() {
		return currentCard;
	}

	public void setCurrentCard(Card currentCard) {
		this.currentCard = currentCard;
	}

	public boolean isWonCurrentGame() {
		return wonCurrentGame;
	}

	public void setWonCurrentGame(boolean wonCurrentGame) {
		this.wonCurrentGame = wonCurrentGame;
	}

	public boolean isWarGame() {
		return isWarGame;
	}

	public void setWarGame(boolean isWarGame) {
		this.isWarGame = isWarGame;
	}

}