package War;

/**Title: WarGame class
 * Description: This class runs the War class by playing a game between two players
 * Copyright: Copyright (c) 2020
 * Company: Heritage College
 * @author Nahom Haile
 * @version 1.0
 ***/

import java.util.ArrayList;
import java.util.Scanner;

public class WarGame {

	static ArrayList<Player> players;
	static War game;

	public WarGame() {

	}

	private static void startGame() {
		Scanner input = new Scanner(System.in);
		
		game = new War();

		ArrayList<Player> players = game.start();

		System.out.println("Both hands have been dealt.");

		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + " has " + players.get(i).getCards().size() + " to start");
		}

		playRound();

		while (!game.isGameOver()) {
			String enter = input.nextLine();
			if (!enter.equalsIgnoreCase("q")) {
				playRound();
			} else {
				System.out.println("Thank you for playing!");
				System.exit(-1);
			}
		}

		Player winner = game.getWinner();
		System.out.println(winner.getName() + " won the game");
	}

	private static void playRound() {
		players = game.play();

		String cardsPlayed = "\n";
		for (int i = 0; i < players.size(); i++) {
			cardsPlayed += players.get(i).getName() + " plays " + players.get(i).getCurrentCard().toString() + ". ";
		}

		System.out.println(cardsPlayed);

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).isWonCurrentGame()) {
				System.out.println(players.get(i).getName() + " won this hand");
			}
			if (players.get(i).isWarGame()) {
				System.out.println("It's a tie! Each Players lays 3 cards face down");
				System.out.println("Kitty has " + game.kitty.size() + " cards");
			}
		}

		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + " has " + players.get(i).getCards().size() + " cards left");
		}

		System.out.println("Hit any key to continue or Q to quit.");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the game of war. \r\n"
				+ "The object of the game is to force the other player to run out of cards.\r\n"
				+ "All the cards are dealt at the beginning of the game.\r\n"
				+ "Each play both players lay the top card of their pile face up. The player with the highest rank card, puts both cards on the bottom of his pile. \r\n"
				+ "If both cards have the same rank, each player plays three cards face down and plays another round.\r\n"
				+ "The winner of the tie-breaking round gets all the played cards (the cards in the tie, the six face down and the two in the tie-breaking play.)\r\n"
				+ "");
		startGame();
	}
}