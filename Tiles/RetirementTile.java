
/*
 * 2024-06-14
 * Lets the player spin for extra money when retired
 */
import java.util.Scanner;
import java.util.Random;
public class RetirementTile extends Tile{

	// Constructor
	public RetirementTile(Player player) {
		super(player);
	}
	
	// Modifier Method
	/*
	 * Pre: The player has retired and there is at least one player who hasn't retired
	 * Post: Gets bonus money
	 * Lets the player spin for extra money
	 */
	public void spinForMoney() {
		Scanner input = new Scanner(System.in);
		Random number = new Random();

		System.out.println("You can spin to get extra money!");
		System.out.println("Enter any button to spin:");
		String spin = input.nextLine();
		int spinNumber = number.nextInt(5)+1;
		System.out.println("You spun a " + spinNumber + "!");
		int money = spinNumber*10000;
		System.out.println("GAIN: $" + money);
		player.addMoney(money);
	}
	
	/*
	 * Pre: It is the player's turn to move
	 * Post: Returns the name of the tile
	 * Gets the tile's name 
	 */
	public String getTileName() {
		return("Retirement");
	}
}




