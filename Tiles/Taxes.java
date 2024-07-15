
/*
* Date: 2024-06-14
* Makes the player pay their taxes
*/
public class Taxes extends Tile{
	// Constructor
	public Taxes(Player player) {
		super(player);
	}
	
	// Modifier method
	/*
	 * Pre:The player lands on a taxes tile
	 * Post: The player loses money depending on their job
	 * The player pays their taxes
	 */
	public void payTaxes() {
		int taxes = player.getJob().getTaxes();
		System.out.println("You need to pay $" + taxes + " for carbon tax!");
		System.out.println("LOSE: $" + taxes);
		player.removeMoney(taxes);
	}
	
	/*
	 * Pre: It is the player's turn to move
	 * Post: Returns the name of the tile
	 * Gets the tile's name
	 */
	public String getTileName() {
		return("Taxes Tile");
	}
}



