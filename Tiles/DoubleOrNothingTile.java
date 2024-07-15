
import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothingTile extends Tile{

	// Constructor
	public DoubleOrNothingTile(Player player) {
		super(player);
		
	}
	
	// Modifier Methods
	
	/*
	 * Pre: The player lands on a double or nothing tile
	 * Post: The player gets or lose money depending on if they won the bet
	 * The player bets how much money they want to gamble
	 */
	public void betAmount() {
		Scanner input = new Scanner(System.in);
		Random number = new Random();
		System.out.println("You are playing Double or Nothing!");
		System.out.println("You will lose money if you spin an even number, and win double if you get an odd number.");
		System.out.println("Enter an amount you want to bet. It can be up to 30,000");
		
		int amount = input.nextInt();
		input.nextLine();
		
		while (amount > 30000 || amount < 0) {
			System.out.println("Enter a valid amount!");
			amount = input.nextInt();
			input.nextLine();
		}
		int money = doubleOrNothing(amount);

		if (money <= 0) {
			player.removeMoney(money);
		} else {
			player.addMoney(amount);
		}

	}
	
	/*
	 * Pre: The player chooses to gamble money
	 * Post: Uses recursion to figure out how much money the player gets in the end
	 * The double or nothing game
	 */
	public int doubleOrNothing(int amount) {
		Random number = new Random();
		Scanner input = new Scanner(System.in);

		if (amount > 0) {
			int generated = number.nextInt(5) + 1;
			System.out.println("You spun a " + generated);
			if (generated % 2 == 0) {
				System.out.println("You spun an even number! You lost your money!");
				System.out.println("LOSE: $" + amount);
				return (0);

			} else {
				System.out.println("You spun an odd number! Your amount has been doubled!");
				amount *= 2;
				System.out.println("Do you want to play again? Enter 1 if yes anything else if no:");
				String choice = input.next();
				input.nextLine();
				if (!choice.equals("1")) {
					System.out.println("You keep your winnings!");
					System.out.println("GAIN: $" + amount);
					return (amount);
				}

				return (2 * doubleOrNothing(amount));
			}
		} else {
			return (0);
		}

	}
	
	// Accessor method
	/*
	 * Pre: It is the player's turn to move 
	 * Post: Returns the name of the tile
	 * Gets the tile's name
	 */
	
	public String getTileName() {
		return("Double Or Nothing Tile");
	}
	
}




