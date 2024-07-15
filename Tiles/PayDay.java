
/*
* 2024-06-14
* Pays the player their salary
*/
public class PayDay extends Tile{
	private int salary;
	
	// Constructor
	public PayDay(Player newPlayer) {
		super(newPlayer);
	}
	
	// Modifier Method
	/*
	 * Pre: The player lands on a pay day tile
	 * Post: The player gets more money
	 * The player gets paid their salary
	 */
	public void payPlayer() {
		salary = player.getJob().getSalary();
		player.addMoney(salary);
		System.out.println("You got paid your salary!");
		System.out.println("GAIN: $" + salary);
	}
	
	// Accessor Method
	/*
	 * Pre: It is the player's turn to move
	 * Post: Returns the name of the tile
	 * Gets the tile's name
	 */
	public String getTileName() {
		return("Payday Tile");
	}
	
	
}
