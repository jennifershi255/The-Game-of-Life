import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Random;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int greatestSpin = 0, goFirst = 0, numPlayers = 0, chooseAdd = 0, choiceAdd2 = 0;
		Player[] players, podium;
		int[] spins = new int[5];
		Queue order = new Queue(5);
		boolean doneGame = false;

		// Teaches the player how to play the game
		startingScreen();

		// Sets the player information
		System.out.println("\r\n" + "█▀ █▀▀ ▀█▀ █░█ █▀█\r\n" + "▄█ ██▄ ░█░ █▄█ █▀▀");
		System.out.println("\nENTER NUMBER OF PLAYERS");
		numPlayers = input.nextInt();
		input.nextLine();

		// checks to sure the number of players is within bounds
		if (numPlayers < 2 || numPlayers > 6) {

			while (numPlayers < 2 || numPlayers > 6) {
				System.out.println("Must have between 1 to 6 players");

				numPlayers = input.nextInt();
				input.nextLine();
			}

		}

		players = new Player[numPlayers];

		// inputting the names of each player
		for (int i = 0; i < numPlayers; i++) {

			System.out.println("Enter the name of player " + (i + 1));

			players[i] = new Player(input.next());
			input.nextLine();

		}

		System.out.println("\n" + "█▀▀ █░█ █▀ ▀█▀ █▀█ █▀▄▀█ █ ▀█ ▄▀█ ▀█▀ █ █▀█ █▄░█\n"
				+ "█▄▄ █▄█ ▄█ ░█░ █▄█ █░▀░█ █ █▄ █▀█ ░█░ █ █▄█ █░▀█");
		// asking if they want to customize the game
		System.out.println("Would you like to add your own tiles to make this game unique?\n1. Yes\n2. No");
		int choose = input.nextInt();
		input.nextLine();
		if (choose == 1) {
			System.out.println(
					"Which tile would you like to add to?\n1. Add house tile\n2. Add expense tile\n3. Add fun fact tile\n4. Add LIFE tile\n5. Exit");
			choose = input.nextInt();
			input.nextLine();
			do {
				if (choose == 1) {

					try {
						FileWriter out = new FileWriter("HouseTile.txt", true);

						BufferedWriter writeFile = new BufferedWriter(out);

						System.out.println("What is the name of the property you would like to add?");

						String name = input.nextLine();

						System.out.println("What is the price of the property you would like to add?");

						int price = input.nextInt();

						input.nextLine();

						writeFile.newLine();

						writeFile.write(name + "-");

						writeFile.write(String.valueOf(price));

						writeFile.close();

						out.close();

					} catch (FileNotFoundException e) {

						System.out.println("File could not be found.");

						System.err.println("FIileNotFoundException: " + e.getMessage());

					} catch (IOException e) {

						System.out.println("Problem with input/output");
						System.err.println("IOException: " + e.getMessage());

					}

					System.out.println(
							"1. Add house tile\n2. Add expense tile\n3. Add fun fact tile\n4. Add LIFE tile\n5. Exit");
					choose = input.nextInt();
					input.nextLine();
				}
				if (choose == 2) {

					try {
						FileWriter out = new FileWriter("ExpenseTile.txt", true);

						BufferedWriter writeFile = new BufferedWriter(out);

						System.out.println("Write an expense you would like to add to the game");

						String expense = input.nextLine();

						writeFile.newLine();

						writeFile.write(expense);

						writeFile.close();

						out.close();

					} catch (FileNotFoundException e) {

						System.out.println("File could not be found.");

						System.err.println("FIileNotFoundException: " + e.getMessage());

					} catch (IOException e) {

						System.out.println("Problem with input/output");
						System.err.println("IOException: " + e.getMessage());

					}

					System.out.println(
							"1. Add house tile\n2. Add expense tile\n3. Add fun fact tile\n4. Add LIFE tile\n5. Exit");
					choose = input.nextInt();
					input.nextLine();

				}
				if (choose == 3) {

					try {
						FileWriter out = new FileWriter("FunFacts.txt", true);

						BufferedWriter writeFile = new BufferedWriter(out);

						System.out.println("Enter a fun fact about sustainability!");

						String fact = input.nextLine();

						writeFile.newLine();

						writeFile.write(fact);

						writeFile.close();

						out.close();

					} catch (FileNotFoundException e) {

						System.out.println("File could not be found.");

						System.err.println("FIileNotFoundException: " + e.getMessage());

					} catch (IOException e) {

						System.out.println("Problem with input/output");
						System.err.println("IOException: " + e.getMessage());

					}

					System.out.println(
							"1. Add house tile\n2. Add expense tile\n3. Add fun fact tile\n4. Add LIFE tile\n5. Exit");
					choose = input.nextInt();
					input.nextLine();
				}
				if (choose == 4) {

					try {
						FileWriter out = new FileWriter("LifeTile.txt", true);

						BufferedWriter writeFile = new BufferedWriter(out);

						System.out.println("Enter a positive LIFE tile to add!");

						String tile = input.nextLine();

						writeFile.newLine();

						writeFile.write(tile);

						writeFile.close();

						out.close();

					} catch (FileNotFoundException e) {

						System.out.println("File could not be found.");

						System.err.println("FIileNotFoundException: " + e.getMessage());

					} catch (IOException e) {

						System.out.println("Problem with input/output");
						System.err.println("IOException: " + e.getMessage());

					}

					System.out.println(
							"1. Add house tile\n2. Add expense tile\n3. Add fun fact tile\n4. Add LIFE tile\n5. Exit");
					choose = input.nextInt();
					input.nextLine();

				}

			} while (choose != 5);

		}

		// spin to see who goes first
		System.out.println(
				"\r\n" + "▀█▀ █░█ █▀█ █▄░█   █▀█ █▀█ █▀▄ █▀▀ █▀█\r\n" + "░█░ █▄█ █▀▄ █░▀█   █▄█ █▀▄ █▄▀ ██▄ █▀▄\n");
		System.out.println("Spin the wheel to determine turn order!\n");

		for (int i = 0; i < numPlayers; i++) {
			int spin = spinner();
			System.out.println(players[i].getName() + " spun a: " + spin);

			if (spin > greatestSpin) {

				greatestSpin = spin;
				goFirst++; // keeps track of the person who spun greatest
			}

			System.out.print("Press enter to continue");
			input.nextLine();
		}

		System.out.println();
		System.out.println(players[goFirst - 1].getName() + " was the highest spinner!");

		order.enqueue(players[goFirst - 1]); // adds greatest spinner to first in line

		// adding the rest of the players to the queue
		for (int i = 0; i < numPlayers; i++) {

			if (players[i] != players[goFirst - 1]) {

				order.enqueue(players[i]);
			}
		}

		System.out.println("Player order is: " + order);
		System.out.println();

		System.out.println("\r\n" + "░░█ █▀█ █▄▄   █▀ █▀▀ ▀█▀ █░█ █▀█\r\n" + "█▄█ █▄█ █▄█   ▄█ ██▄ ░█░ █▄█ █▀▀");
		// Setting the player's education
		for (int i = 0; i < numPlayers; i++) {
			System.out.println();
			System.out.println(order.front().getName() + ": What path do you want to take?\n1. Degree\n2. No Degree");

			String choice = input.next();
			input.nextLine();

			if (choice.equals("1")) { // if they chose a degree path

				System.out.println("You have $10,000 to start with. \n"
						+ "You borrow $50,000 from the bank to pay for your tuition. \n"
						+ "You currently have -$40,000.");
				System.out.println("___________________________________\n" + "|#######====================#######|\n"
						+ "|#(1)*    THE GAME OF LIFE    *(1)#|\n" + "|#**          /===\\   ********  **#|\n"
						+ "|*# {G}      | (\") |             #*|\n" + "|#*  ******  | /v\\ |    $$$$$    *#|\n"
						+ "|#(1)         \\===/            (1)#|\n" + "|##==========  DOLLAR  ===========##|\n"
						+ "------------------------------------");
				System.out.print("Press enter to draw a career card");
				input.nextLine();
				CareerTile career = new CareerTile(order.front(), numPlayers);
				career.setFirstJob(true);
				order.front().setMoney(-40000);
				order.front().setArrayIndex(1);
				order.front().setTileIndex(0);

			} else { // if they chose no degree path
				System.out.println("You have $10,000 to start with.");
				System.out.println("___________________________________\n" + "|#######====================#######|\n"
						+ "|#(1)*    THE GAME OF LIFE    *(1)#|\n" + "|#**          /===\\   ********  **#|\n"
						+ "|*# {G}      | (\") |             #*|\n" + "|#*  ******  | /v\\ |    $$$$$    *#|\n"
						+ "|#(1)         \\===/            (1)#|\n" + "|##==========  DOLLAR  ===========##|\n"
						+ "------------------------------------");
				System.out.print("Press enter to draw a career card");
				input.nextLine();
				CareerTile career = new CareerTile(order.front(), numPlayers);
				career.setFirstJob(false);
				order.front().setMoney(10000);
				order.front().setArrayIndex(0);
				order.front().setTileIndex(0);
			}

			System.out.println(order.front().getJob());
			System.out.print("              ,\n" + "     __  _.-\"` `'-.\n" + "    /||\\'._ __{}_(\n"
					+ "    ||||  |'--.__\\\n" + "    |  L.(   ^_\\^\n" + "    \\ .-' |   _ |\n" + "    | |   )\\___/\n"
					+ "    |  \\-'`:._]\n" + "    \\__/;      '-.");
			Player justWent = order.dequeue(); // removes the player who just played from the front
			order.enqueue(justWent); // adds the player who just played to the back of the queue

		}

		// Sets up the positions for all the players
		while (doneGame == false) {

			for (int i = 0; i < numPlayers; i++) {

				Player person = order.front();
				Paths move = new Paths(person, numPlayers);

				System.out.println(
						"\r\n" + "█▄░█ █▀▀ ▀▄▀ ▀█▀   ▀█▀ █░█ █▀█ █▄░█\r\n" + "█░▀█ ██▄ █░█ ░█░   ░█░ █▄█ █▀▄ █░▀█");
				System.out.println("‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧");

				System.out.println("\n" + person.getName() + "'s turn.");
				System.out.println("\nCurrent Location:");
				move.displayPath();

				if (!move.getRetired()) {

					// The player spins the number of spaces they move
					System.out.println("\nPress enter to spin:");
					input.nextLine();
					int spin = spinner();
					System.out.println(person.getName() + " spun a: " + spin);

					// The player arrives at their new location
					move.movePlayer(spin);
					System.out.println("\nNew location:\n");
					move.displayPath();

				} else {
					// Gives message if the player is retired and cannot move
					System.out.println("You have reached retirement!");
					person.setTileIndex(5);
					person.setRetired(true);
				}

				System.out.println("");
				move.doTileAction(); // Does the action of the tile that the player lands on
				Player justWent = order.dequeue(); // removes the player who just played from the front
				order.enqueue(justWent);

				System.out.print("Press any character to continue");
				input.nextLine();

			}

			doneGame = checkIfDone(players, numPlayers);
		}

		System.out.println("▒█▀▄▒██▀░▄▀▀░█▒█░█▒░░▀█▀░▄▀▀\n" + "░█▀▄░█▄▄▒▄██░▀▄█▒█▄▄░▒█▒▒▄██\n" + "");

		for (int i = 0; i < numPlayers; i++) {

			for (int j = 0; j < numPlayers - 1; j++) {

				if (players[j].getTotalMoney() < players[j + 1].getTotalMoney()) {

					Player temp = players[j];

					players[j] = players[i + 1];

					players[j + 1] = temp;

				}
			}
		}

		for (int i = 0; i < numPlayers; i++) {
			if (i == 0) {
				System.out.println(
						" " + "          \\'-=======-'/\n" + "          _|   .=.   |_\n" + "         ((|  {{1}}  |))\n"
								+ "          \\|   /|\\   |/\n" + "           \\__ '`' __/\n" + "             _`) (`_\n"
								+ "           _/_______\\_\n" + "          /___________\\ " + "\n" + players[i]);
			} else {
				System.out.println((i + 1) + ":\n" + players[i]);

			}

		}
		System.out.println();
	}

	/*
	 * Pre: All players have had their turn Post: Returns true if all players have
	 * reached retirement Checks if the game has finished
	 */
	public static boolean checkIfDone(Player[] players, int numPlayers) {

		for (int i = 0; i < players.length; i++) {
			if (players[i].getRetired() == false) {
				return (false);
			}
		}

		return (true);

	}

	/*
	 * Pre: The user starts the game up Post: The player knows how to play Shows the
	 * starting screen for the game
	 */
	public static void startingScreen() {
		Scanner userInput = new Scanner(System.in);
		System.out.println(
				"\r\n" + "░██████╗░░█████╗░███╗░░░███╗███████╗  ░█████╗░███████╗  ██╗░░░░░██╗███████╗███████╗\r\n"
						+ "██╔════╝░██╔══██╗████╗░████║██╔════╝  ██╔══██╗██╔════╝  ██║░░░░░██║██╔════╝██╔════╝\r\n"
						+ "██║░░██╗░███████║██╔████╔██║█████╗░░  ██║░░██║█████╗░░  ██║░░░░░██║█████╗░░█████╗░░\r\n"
						+ "██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░  ██║░░██║██╔══╝░░  ██║░░░░░██║██╔══╝░░██╔══╝░░\r\n"
						+ "╚██████╔╝██║░░██║██║░╚═╝░██║███████╗  ╚█████╔╝██║░░░░░  ███████╗██║██║░░░░░███████╗\r\n"
						+ "░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝  ░╚════╝░╚═╝░░░░░  ╚══════╝╚═╝╚═╝░░░░░╚══════╝");

		System.out.println("\n------------------------------------------------------------------------------------");

		System.out.println(
				"‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊˚❀༉‧₊˚.‧₊\n");

		System.out.println("\r\n" + "█ █▄░█ █▀ ▀█▀ █▀█ █░█ █▀▀ ▀█▀ █ █▀█ █▄░█ █▀\r\n"
				+ "█ █░▀█ ▄█ ░█░ █▀▄ █▄█ █▄▄ ░█░ █ █▄█ █░▀█ ▄█");

		// Asks if the user knows how to play the game
		System.out.println("\nDo you know how to play? \n" + "1. Input 1 if no.\n" + "2. Any other number if yes");
		String choice = userInput.next();
		userInput.nextLine();

		if (choice.equals("1")) { // Tells the player how the game goes

			System.out.println("\r\n" + "█▀▀ ▄▀█ █▀▄▀█ █▀▀   █▀█ █░█ ▀█▀ █░░ █ █▄░█ █▀▀\r\n"
					+ "█▄█ █▀█ █░▀░█ ██▄   █▄█ █▄█ ░█░ █▄▄ █ █░▀█ ██▄");

			System.out.println("\n. First select the number of players\n"
					+ "\n2. Each player chooses an educational path to take (Career vs College)\n"
					+ "\n3. Players take turns spinning a wheel to move along the board \n"
					+ "\n4. They will land on a tile each turn, with each tile resulting in different outcomes. "
					+ "\n\nExamples of tiles include: \n" + "-Pay Day \n" + "-Changing careers\n" + "-Buying a house\n"
					+ "-Pay carbon taxes \n" + "-Life spaces\n" + "-Babies \n" + "-Get Married \n"
					+ "\n5. By landing on different tiles, investing in houses, having kids, and obtaining jobs, players will earn money throughout their journey.\n"
					+ "When a player reaches the retirement tile before all players have reached it, they can spin a wheel to continue to get money. They can no longer move from their space. \n"
					+ "\n6. The game ends when all players reach the retirement tile. The person with the most money and asset value including the amount of people they have. \n");
			System.out.print("Press any character to continue");
			userInput.nextLine();
		}
	}

	/*
	 * Pre: The player spins the wheel Post: Returns a number that they spun The
	 * player spins a spinner
	 */
	public static int spinner() {
		Random r = new Random();
		int spin = r.nextInt(5) + 1;

		if (spin == 1) {
			System.out.println("    _____________\n" + "  .-'      1      `-.\n" + " /         ^          \\\n"
					+ "|   5      |      2   |\n" + "|          .          |\n" + "|                     |\n"
					+ " \\    4        3     /\n" + "  `-._____________.-'");
		} else if (spin == 2) {
			System.out.println("    _____________\n" + "  .-'      1      `-.\n" + " /               >2  \\\n"
					+ "|   5          /     |\n" + "|          . /         |\n" + "|                     |\n"
					+ " \\    4        3     /\n" + "  `-._____________.-'");
		} else if (spin == 3) {
			System.out.println("    _____________\n" + "  .-'      1      `-.\n" + " /                    \\\n"
					+ "|   5             2   |\n" + "|          .          |\n" + "|            \\       |\n"
					+ " \\    4       > 3     /\n" + "  `-._____________.-'");
		} else if (spin == 4) {
			System.out.println("    _____________\n" + "  .-'      1      `-.\n" + " /                    \\\n"
					+ "|   5             2   |\n" + "|          .          |\n" + "|         /            |\n"
					+ " \\    4</        3   /\n" + "  `-._____________.-'");
		} else if (spin == 5) {
			System.out.println("    _____________\n" + "  .-'      1      `-.\n" + " /                    \\\n"
					+ "|   5 < \\          2  |\n" + "|         \\ .          |\n" + "|                     |\n"
					+ " \\    4        3     /\n" + "  `-._____________.-'");
		}

		return spin;
	}
}
