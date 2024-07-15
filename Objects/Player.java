public class Player {
	// Instance variables
	private String name;
	private int money;
	private int arrayIndex;
	private int tileIndex;
	private int peopleInCar;
	private Job job;
	private LinkedList property;
	private boolean retired;
	private int total;
	// Constructor
	public Player(String newName) {
		name = newName;
		job = new Job("", 0, 0, true);
		arrayIndex = 0;
		tileIndex = 0;
		retired = false;
		total =0;
		property = new LinkedList();
		peopleInCar = 1;
		money = 10000;
	}
	// Modifier Methods
	
	/*
	 * Pre: The player is on a retirement tile
	 * Post: Sets retired to true if the player is retired
	 * Sets retirement status
	 */
	public void setRetired(boolean newRetired) {
		retired = newRetired;
	}
/*
	 * Pre: The player enters the game
	 * Post: Sets the starting money for a player
	 * Sets how much money a player has
	 */
	public void setMoney(int newMoney) {
		money = newMoney;
	}
	/*
	 * Pre: The player gets money from a tile
	 * Post: The playey's money increases
	 * Gives more money to a player
	 */
	public void addMoney(int newMoney) {
		money += newMoney;
	}
	
	/*
	 * Pre: The player loses money from a tile
	 * Post: The player has less money
	 * Takes money away the player
	 */
public void removeMoney(int loseMoney) {
		money -= loseMoney;
	}
	/*
	 * Pre: The player lands on a baby tile
	 * Post: Increases the number of people with the player by 1
	 * Adds a family member
	 */
	public void addPeople() {
		peopleInCar++;
	}
	/*
	 * Pre: The player buys a property
	 * Post: Adds a property to a list of properties owned
	 * Owns another property
	 */
	public void addProperty(Property p) {
		property.addToFront(p);
	}
	/*
	 * Pre: The player chooses a path
	 * Post: The player moves to a new path
	 * Sets the path the player is on
	 */
	public void setArrayIndex(int newArrayIndex) {
		arrayIndex = newArrayIndex;
	}
	/*
	 * Pre: The player moves spaces
	 * Post: The player is on a new space
	 * Sets the space the player is on
	 */
	public void setTileIndex(int newTileIndex) {
		tileIndex = newTileIndex;
	}
	// Accessor Methods
	/*
	 * Pre: The main method or paths object checks if a player has retired
	 * Post: Returns if the player has retired or not
	 * Returns the player's retired status
	 */
	public boolean getRetired() {
		return (retired);
	}
	/*
	 * Pre: The player's money is needed
	 * Post: Return the amount of money the player currently has
	 * Gets the player's money
	 */
	public int getMoney() {
		return (money);
	}
	/*
	 * Pre: The player has set their name
	 * Post: Returns a string of the player's name
	 * Gets the player's name
	 */
	public String getName() {
		return (name);
	}
	/*
	 * Pre: The player object was made
	 * Post: Returns the number of people the player has
	 * Gets the number of family members the player has in game
	 */
	public int getNumOfPeopleInCar() {
		return (peopleInCar);
	}
	/*
	 * Pre: All players have reached retirement
	 * Post: Returns the total value of assets and money the player has
	 * Gets the player's total wealth
	 */
	public int getTotalMoney() {
		total = getMoney() + (peopleInCar * 50000) + property.getTotal();
		return total;
	}
	/*
	 * Pre: The player has a job set
	 * Post: Returns the job object
	 * Returns information and methods about the player's job
	 */
	public Job getJob() {
		return (job);
	}
	/*
	 * Pre: The player class is created
	 * Post: Returns the list of properties owned by the player
	 * Gets the player's properties
	 */
	public void getPropertiesList() {
		System.out.println(property);
	}
	/*
	 * Pre: The player's path index is set
	 * Post: Gets the player's path index
	 * Get the number of the path the player is on
	 */
	public int getArrayIndex() {
		return (arrayIndex);
	}
	/*
	 * Pre: The player's tile index is set
	 * Post: Gets the player's tile index
	 * Get the number of the space the player is on
	 */
	public int getTileIndex() {
		return (tileIndex);
	}
	// Helper Methods
	/*
	 * Pre: The player class is made
	 * Post: Returns the player's variables
	 * Information about the player is displayed
	 */
	public String toString() {
		String info = "Player Name: " + name + "\nMoney: $" + money + "\nPeople in Car: " + peopleInCar
				+ "\nProperties: " + property + "\nTOTAL MONEY: $" + total;
		// Add properties here later
		return (info);
	}
}



