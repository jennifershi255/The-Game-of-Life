
public class BabyTile extends Tile{
	
	// Constructor
	public BabyTile(Player newPlayer) {
		super(newPlayer);
	}
	
	// Modifier Method
	/*
	 * Pre: The player lands on a Baby Tile
	 * Post: The player has a person added to their family
	 * The player gets a child
	 */
	public void addBaby() {
		System.out.println("You got a new baby!");
		System.out.println("A person was added to your family.");
		player.addPeople();
	}
	
	// Accessor Method
	/*
	 * Pre: It is the player's turn to move
	 * Post: Returns the name of the tile
	 * Gets the tile's name
	 */
	public String getTileName() {
		return("Baby Tile");
	}
}



