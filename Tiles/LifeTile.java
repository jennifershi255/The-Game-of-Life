/*
* Date: 2024-06-10
* Gets money based on a random life event
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
public class LifeTile extends Tile{
	private String[] lifeTile;
	private int lines;
	
	// Constructor
	public LifeTile(Player player) {
		super(player);
		lines = countLines();
		lifeTile = new String [lines];
		
		// Reads and puts the lines in the txt in an array
		try (BufferedReader reader = new BufferedReader(new FileReader("LifeTile.txt"))) {
			String line;
			int count = 0;
			while ((line = reader.readLine()) != null) {
				String tile = line;
				lifeTile[count] = tile;
				count++;
				
			}
			
			
		} catch (IOException e) {
			System.out.println("Problem reading from file: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Pre: The player lands on a life tile
	 * Post: The player gets money based on a fortunate event
	 * The player gets money based on a good life event
	 */
	public void getLifeTile() {
		Random number = new Random();
		int generated = number.nextInt(lines);
		System.out.println(lifeTile[generated]);
		
		int cost = number.nextInt(50000) + 10000;
		System.out.println("GAIN: $" + cost);
		player.addMoney(cost);
	}
	
	
	/*
	 * Pre: The life tile is initialized
	 * Post: Returns the number of lines in the tlifeTile.txt file
	 * Counts the number of lines in the file
	 */
	public static int countLines() {
		try (BufferedReader reader = new BufferedReader(new FileReader("LifeTile.txt"))) {
			
			int numOfLines = 0;
           while (reader.readLine() != null) {
           	numOfLines++;
           }
            return(numOfLines);
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception: " + e.getMessage());
			e.printStackTrace();
			return(0);
		} catch (IOException e) {
			System.out.println("Problem reading from file: " + e.getMessage());
			e.printStackTrace();
			return(0);
		}
	}
	
	
	/*
	 * Pre: It is the player's turn to move
	 * Post: Returns the name of the tile
	 * Gets the tile's name
	 */
	public String getTileName() {
		return("Life Tile");
	}
	
}

