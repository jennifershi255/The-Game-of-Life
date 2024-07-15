
/*
 * Date: 2024-06-14
 * Author: Jennifer
 * Creates a lottery scratch ticket game
 */

import java.util.Random;
import java.util.Scanner;

public class LotteryGame extends Tile {
	private String[][] lottery = { { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" } };
	private int[] value = { 0, 1000, 10000, 20000, 30000, 50000, 100000 };
	private int gain;

	// Constructor
	public LotteryGame(Player player) {
		super(player);
		gain = 0;
	}

	/*
	 * Pre: The player lands on the lottery game tile
	 * Post: Shows the scratch ticket with the numbers hidden
	 * Shows the scratch ticket
	 */
	public void displayBoard() {
		System.out.println("-----------");
		for (int i = 0; i < lottery.length; i++) {
			for (int j = 0; j < lottery[i].length; j++) {
				System.out.print("|" + lottery[i][j] + "| ");
			}

			System.out.println();
			System.out.println("-----------");
		}

	}

	/*
	 * Pre: The player lands on the lottery game tile
	 * Post: The player picks a letter to scratch off and gets money based off it
	 * The player plays the lottery minigame. 
	 */
	public int scratchOff() {

		Random r = new Random();

		Scanner s = new Scanner(System.in);

		boolean found = false;

		System.out.println("Enter letter you wish to scratch");

		String letter = s.next();

		s.nextLine();

		for (int i = 0; i < lottery.length; i++) {

			for (int j = 0; j < lottery[i].length; j++) {

				if (letter.equalsIgnoreCase(lottery[i][j])) {

					found = true;

					int index = r.nextInt(7);

					gain = value[index];
					
					
				}
				
			}

		}

		if (found != true) {

			while (found != true) {

				System.out.println("Enter a letter from the board");

				letter = s.next();
				s.nextLine();

				for (int i = 0; i < lottery.length; i++) {

					for (int j = 0; j < lottery[i].length; j++) {

						if (letter.equalsIgnoreCase(lottery[i][j])) {

							found = true;
							
							int index = r.nextInt(7);

							gain = value[index];
							
						
						}
					}

				}
			}
		}
		 
		
		for (int i = 0; i < lottery.length; i++) {
		
			for (int j = 0; j < lottery[i].length; j++) {
	
				if (letter.equalsIgnoreCase(lottery[i][j])) {
					lottery[i][j] = "$" + gain + "";
				} else {
					int index = r.nextInt(7);
					lottery[i][j] = "$" + value[index] + "";
					
				}
			}
			}
		
		
		System.out.println("--------------------------------------------");
		for (int i = 0; i < lottery.length; i++) {
			for (int j = 0; j < lottery[i].length; j++) {
				
				if (lottery[i][j].equals("$0")) {
					
					System.out.print(" |    " + lottery[i][j] + "    |   ");
					
				} else if (lottery[i][j].equals("$1000")){
					System.out.print(" |  " + lottery[i][j] + "   |   ");
					
				} else if (lottery[i][j].equals("$10000") || lottery[i][j].equals("$20000") || lottery[i][j].equals("$30000") || lottery[i][j].equals("$50000")){
					System.out.print(" |  " + lottery[i][j] + "  |  ");
				} else {
					
					System.out.print(" |  " + lottery[i][j] + " |  ");
				}
			
			}

			System.out.println();
			System.out.println("--------------------------------------------");
		}
		System.out.println("GAIN: $" + gain);
		player.addMoney(gain);
		return gain;
	}
	
	
	public void displayResults() {
		Random r = new Random();
		System.out.println("-----------");
		for (int i = 0; i < lottery.length; i++) {
			for (int j = 0; j < lottery[i].length; j++) {
				System.out.print("|" + lottery[i][j] );
			}

			System.out.println();
			System.out.println("-----------");
		}
	}

	
	/*
	 * Pre: It is the player's turn to move
	 * Post: Returns the name of the tile
	 * Gets the tile's name 
	 */
	public String getTileName() {
		return ("Lottery Tile");
	}

}







