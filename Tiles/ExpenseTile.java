
/*
* Date: 2024-06-14
* The player gets a random expense
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
	// Constuctor
public class ExpenseTile extends Tile{
	private int lines;
	private String[] expenseTile;
	
		// Reads and puts the lines in the txt in an array
	public ExpenseTile(Player player) {
		super(player);
		lines = countLines();
		expenseTile = new String [lines];
		
		try (BufferedReader reader = new BufferedReader(new FileReader("ExpenseTile.txt"))) {
			String line;
			
			int count = 0;
			while ((line = reader.readLine()) != null) {
				String tile = line;
				expenseTile[count] = tile;
				count++;
			}
			
		} catch (IOException e) {
			System.out.println("Problem reading from file: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	// Helper
		/*
		 * Pre: The expense tile is initialized
		 * Post: Returns the number of lines in the ExpenseTile.txt file
		 * Counts the number of lines in the file
		 */
		public static int countLines() {
			try (BufferedReader reader = new BufferedReader(new FileReader("ExpenseTile.txt"))) {
				int numOfLines = 0;
		        String line;
		        while ((line = reader.readLine()) != null) {
		            if (!line.trim().isEmpty()) {
		                numOfLines++;
		            }
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
	
	// Accessor Method
	/*
	 * Pre:The player lands on an expense tile
	 * Post: The player loses money
	 * The
	 * player gets charged money based on a random life event
	 */
	public void getExpense() {
		
		Random number = new Random();
		int generated = number.nextInt(40000) + 10000;
		int cost = generated;
		generated = number.nextInt(lines);
		System.out.println(expenseTile[generated]);
		System.out.println("LOSE: $" + cost);
		player.removeMoney(cost);
		
	}
	
	/*
	 * Pre: It is the player's turn to move
	 * Post: Returns the name of the tile
	 * Gets the tile's name
	 */
	public String getTileName() {
		return("Expense Tile");
	}
}



