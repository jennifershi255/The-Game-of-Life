
/*
 * Date: 2024-06-14
 * Author: Shelly
 * Moves the player and does the action of the tile they land on
 */

import java.util.Scanner;

public class Paths {

	int arrayIndex;
	int tileIndex;
	Tile[][] arrayOfArrays;
	boolean retired;
	Player player;
	
	// Constructor
	public Paths(Player newPlayer, int numOfPlayers) {
		retired = false;
		player = newPlayer;
		arrayIndex = player.getArrayIndex();
		tileIndex = player.getTileIndex();
		arrayOfArrays = new Tile[10][];

		
		// Initializes the board 
		arrayOfArrays[0] = new Tile[] {new CareerTile(player, numOfPlayers), new FunFactTile(player), new PayDay(player), new PayDay(player) }; // career
																											// left
		arrayOfArrays[1] = new Tile[] {new CareerTile(player, numOfPlayers), new ExpenseTile(player), new ExpenseTile(player), new LifeTile(player),
				new FunFactTile(player), new LifeTile(player) }; // college right
		arrayOfArrays[2] = new Tile[] { new PayDay(player), new LifeTile(player), new PayDay(player),
				new ExpenseTile(player), new HouseTile(player) }; // normal left
		arrayOfArrays[3] = new Tile[] { new FunFactTile(player), new ExpenseTile(player), new FunFactTile(player),
				new ExpenseTile(player), new CareerTile(player, numOfPlayers) }; // study right
		arrayOfArrays[4] = new Tile[] { new Taxes(player), new BabyTile(player), new LifeTile(player),
				new PayDay(player), new LifeTile(player) }; // normal left
		arrayOfArrays[5] = new Tile[] { new HouseTile(player), new LifeTile(player), new Taxes(player),
				new LotteryGame(player), new PayDay(player) }; // house right
		arrayOfArrays[6] = new Tile[] { new BabyTile(player), new Taxes(player), new ExpenseTile(player),
				new BabyTile(player), new PayDay(player) }; // baby left
		arrayOfArrays[7] = new Tile[] { new HouseTile(player), new BabyTile(player), new LifeTile(player),
				new Taxes(player), new PayDay(player) }; // house right
		arrayOfArrays[8] = new Tile[] { new LotteryGame(player), new DoubleOrNothingTile(player), new PayDay(player),
				new LotteryGame(player), new DoubleOrNothingTile(player), new RetirementTile(player)}; // gambling left
		arrayOfArrays[9] = new Tile[] { new LifeTile(player), new PayDay(player), new Taxes(player),
				new DoubleOrNothingTile(player), new ExpenseTile(player), new RetirementTile(player)}; // retirement right

	}
	
	/*
	 * Pre: The player is about to move or has just moved
	 * Post: Displays the path that the player is currently on and their location
	 * Displays the part of the board the player is on
	 */
	public void displayPath() {
		System.out.println("Path #" + (arrayIndex+1));
		for (int i = 0; i < arrayOfArrays[arrayIndex].length; i++) {
			if (i != tileIndex) {
				System.out.println("[  ] - " + arrayOfArrays[arrayIndex][i].getTileName());
			} else {
				System.out.println("[" + player.getName() + "] - " + arrayOfArrays[arrayIndex][i].getTileName());
			}
			
		}
		
	}
	
	/*
	 * Pre: The game checks if the player has retired or not 
	 * Post:  Returns true if the player has retired
	 * Gets whether
	 */
	public boolean getRetired() {
		if ((arrayIndex == 8 && tileIndex == 5) || (arrayIndex == 9 && tileIndex == 5)) {
			return(true);
		} else {
			return(false);
		}
	}
	public void doTileAction() {
		Scanner input = new Scanner(System.in);
		Tile tile = arrayOfArrays[arrayIndex][tileIndex];
		System.out.println("You landed on a " + tile.getTileName() + "!");
		
		if (tile instanceof BabyTile) {
			BabyTile babyTile = (BabyTile) tile;
			babyTile.addBaby();
		} else if (tile instanceof CareerTile) {
			CareerTile careerTile = (CareerTile) tile;
			System.out.println("Do you want to switch jobs or get a pay raise?");
			System.out.println("Enter 1 to switch jobs, 2 to get a pay raise:");
			String choice = input.next();
			while (!(choice.equals("1") || choice.equals("2"))) {
				System.out.println("Enter 1 or 2!");
				choice = input.next();
			}
			
			if (choice.equals("1")) {
				careerTile.setJobWithChoice();
			} else {
				careerTile.payRaise();
			}
			
			
		} else if (tile instanceof DoubleOrNothingTile) {
			DoubleOrNothingTile doubleOrNothingTile = (DoubleOrNothingTile) tile;
			doubleOrNothingTile.betAmount();
		} else if (tile instanceof ExpenseTile) {
			ExpenseTile expenseTile = (ExpenseTile) tile;
			expenseTile.getExpense();
		} else if (tile instanceof FunFactTile) {
			FunFactTile funFactTile = (FunFactTile) tile;
			funFactTile.getFunFact();
		} else if (tile instanceof HouseTile) {
			HouseTile houseTile = (HouseTile) tile;
			
			System.out.println("Would you like to buy or sell a house?");
			System.out.println("Enter 1 to buy a house, 2 to sell a house, anything else to do nothing.");
			String choice = input.next();
			input.nextLine();
			
			if (choice.equals("1")) {
				houseTile.buyHouse(); 
			} else if (choice.equals("2")) {
				houseTile.sellHouse();
			} else {
				System.out.println("You chose to do nothing.");
			}
		
		} else if (tile instanceof LifeTile) {
			LifeTile lifeTile = (LifeTile) tile;
			lifeTile.getLifeTile();
		} else if (tile instanceof LotteryGame) {
			LotteryGame lotteryGameTile = (LotteryGame) tile;
			lotteryGameTile.displayBoard();
			lotteryGameTile.scratchOff();
		} else if (tile instanceof PayDay) {
			PayDay payDayTile = (PayDay) tile;
			payDayTile.payPlayer();
		} else if (tile instanceof RetirementTile) {
			RetirementTile retirementTile = (RetirementTile) tile;
			retirementTile.spinForMoney();
		} else if (tile instanceof Taxes) {
			Taxes taxesTile = (Taxes) tile;
			taxesTile.payTaxes();
		} else {
			System.out.println("Something went wrong!");
		}
		
		
	}
	public Tile movePlayer(int spaces) {
		
		
		Scanner input = new Scanner(System.in);
		if (getRetired()) {
			System.out.println("You cannot move as you have reached retirement!");
			
		} else {
			int newIndex = (tileIndex + spaces) % arrayOfArrays[arrayIndex].length;

			// Calculate the number of spaces moved along the current path
			
			if (getRetired()) {
				System.out.println("You have retired!");
				newIndex = 5;
				player.setRetired(true);
			} else {
				
				
				if (newIndex <= tileIndex) {
					
					if (arrayIndex == 8 || arrayIndex == 9) { // never plays 
						System.out.println("You have reached retirement!");
						newIndex = 5;
						player.setRetired(true);
					} else {
						System.out.println("You have found a divide in the road!");
					    System.out.println("Do you want to go on the left or right path?"); // Maybe have a display here later 
						System.out.println("Enter 1 to go on the left path, and 2 right to go on the right path.");
						String choice = input.nextLine();
						while (!(choice.equals("1") || choice.equals("2"))) {
							System.out.println("Enter 1 or 2!");
							choice = input.nextLine();
						}
						
						int newArrayIndex;
						if (arrayIndex%2 == 0) { // currently on a left path
							if (choice.equals("1")) { // wants to go to the left path
								newArrayIndex = arrayIndex+=2;
							} else { // wants to go to the right path
								newArrayIndex = arrayIndex+=3;
							}
							
						} else { // currently on a right path
							if (choice.equals("1")) {// wants to go to the left path
								newArrayIndex = arrayIndex+=1;
							} else {// wants to go to the right path
								newArrayIndex = arrayIndex+=2;
							}
						}
						arrayIndex = newArrayIndex;
					}
					
					
				}
				
				player.setArrayIndex(arrayIndex);
				tileIndex = newIndex;
				player.setTileIndex(tileIndex);
			}

			
			
		}
		
		
		return(arrayOfArrays[arrayIndex][tileIndex]);
	
		
	}

}




