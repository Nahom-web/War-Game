package War;

/**Title: Card class
 * Description: This class creates a new card with a rank and a suit 
 * Copyright: Copyright (c) 2020
 * Company: Heritage College
 * @author Nahom Haile
 * @version 1.0
 ***/

public class Card implements Comparable<Card> {

	private String rank;
	private String suit;
	private int value;

	public Card(String r, String suits, int v) {
		this.suit = suits;
		this.rank = r;
		this.value = v;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString() {
		return this.rank + " of " + this.suit;
	}

	@Override
	public int compareTo(Card card) {
		if (this.value > card.value)
			return 1;
		else if (this.value < card.value)
			return -1;
		else
			return 0;
	}

}
