import java.io.*;
import java.util.Random;

public class FunFactTile extends Tile {
	private String[] funFactTile;
	private int lines;

	// Constructor
	public FunFactTile(Player player) {
		super(player);
		lines = countLines();
		funFactTile = new String[lines];

		// Reads and puts the lines in the txt in an array
		try (BufferedReader reader = new BufferedReader(new FileReader("FunFacts.txt"))) {
			String line;

				int count = 0;
				while ((line = reader.readLine()) != null) {

					String tile = line;

					funFactTile[count] = tile;

					count++;
				}
			}

		 catch (IOException e) {
			System.out.println("Problem reading from file: " + e.getMessage());
			e.printStackTrace();
		}


	}

	// Helper method
	/*
	 * Pre: The fun fact tile is initialized Post: Returns the number of lines in
	 * the txt file Counts the number of lines in the file
	 */
	public static int countLines() {

		try (BufferedReader reader = new BufferedReader(new FileReader("HouseTile.txt"))) {
			int numOfLines = 0;
			while (reader.readLine() != null) {
				numOfLines++;
			}
			return (numOfLines);
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception: " + e.getMessage());
			e.printStackTrace();
			return (0);
		} catch (IOException e) {
			System.out.println("Problem reading from file: " + e.getMessage());
			e.printStackTrace();
			return (0);
		}
	}

	// Accessor Methods
	/*
	 * Pre: The player lands on a fun fact tile Post: They get a fun fact relating
	 * to environemntal stewardship and sustainability The user gets a fun fact
	 */
	public void getFunFact() {
		Random number = new Random();
		int generated = number.nextInt(lines);
		System.out.println("DID YOU KNOW?: " + funFactTile[generated]);
	}

	/*
	 * Pre: It is the player's turn to move Post: Returns the name of the tile Gets
	 * the tile's name
	 */
	public String getTileName() {
		return ("Fun Fact Tile");
	}

}
