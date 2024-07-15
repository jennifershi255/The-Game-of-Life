
/*
* Date: 2024-06-10
* Lets the user buy and sell houes
*/
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class HouseTile extends Tile {
	private int lines;
	LinkedList properties;
	private Property[] selection;

	public HouseTile(Player player) {
		super(player);
		lines = countLines();
		selection = new Property[lines];
		properties = new LinkedList();

		// Inputs the names and costs of houses from a file into an array
		try (BufferedReader reader = new BufferedReader(new FileReader("HouseTile.txt"))) {
			Scanner input = new Scanner(reader);
			String line;
			String[] temp = new String[2];
			String name;
			int cost;
			String substring;
			int counter = 0;
			int listCounter = 0;
			int startIndex;

			while (input.hasNextLine()) {
				line = input.nextLine();
				startIndex = 0;
				counter = 0;
				// Splits the read line into parts
				for (int i = 0; i < line.length(); i++) {
					substring = "";
					if (line.charAt(i) == '-') {
						substring = line.substring(startIndex, i);
						startIndex = i + 1;
						temp[counter] = substring;
						counter++;
					} else if (i == line.length() - 1) {
						substring = line.substring(startIndex, i + 1);
						temp[counter] = substring;
						counter++;
					}
				}
				listCounter++;
				// Assigns the parts into their categories
				name = temp[0];
				cost = Integer.parseInt(temp[1]);
				// Initializes the object
				selection[listCounter - 1] = new Property(name, cost);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem reading from file: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void writeHouse() {
		Scanner s = new Scanner(System.in);
		
		
		int choice = 0;

		try {
			FileWriter out = new FileWriter("HouseTile.txt", true);
			
			BufferedWriter writeFile = new BufferedWriter(out);
			
			System.out.println("1. Add more\n2. Exit");
			
			choice = s.nextInt();
			
			s.nextLine();
			
			while (choice != 2) {
				
				System.out.println("What is the name of the property you would like to add?");
				
				String name = s.nextLine();
				
				System.out.println("What is the price of the property you would like to add?");
				
				int price = s.nextInt();
				
				s.nextLine();
				
				writeFile.newLine();
				
				writeFile.write(name +"-");
				
				writeFile.write(String.valueOf(price));
				
				System.out.println("1. Add more\n2. Exit");
				
				choice = s.nextInt();
				
				s.nextLine();
				
			}
			
			writeFile.close();
			
			out.close();
			

		} catch (FileNotFoundException e) {

			System.out.println("File could not be found.");

			System.err.println("FIileNotFoundException: " + e.getMessage());

		} catch (IOException e) {

			System.out.println("Problem with input/output");
			System.err.println("IOException: " + e.getMessage());

		}
		
	}

	/*
	 * Pre: The user lands on a house tile and wants to sell a house Post: The user
	 * sells a house and gets money for it. Lets the player sell their property
	 */
	public void sellHouse() {
		Scanner userInput = new Scanner(System.in);
		Random number = new Random();
		if (properties.isEmpty()) {
			System.out.println("You have no houses to sell.");
		} else {
			System.out.println("Here are the properties that you own:");
			System.out.println(properties);
			System.out.println("Enter the name of the property you want to sell:");
			String name = userInput.nextLine();
			int raise = number.nextInt(10) + 1;
			raise = raise * 10000;
			int sellPrice = properties.removeNode(name) + raise;
			player.addMoney(sellPrice);
			System.out.println("GAIN: " + sellPrice);
		}
	}

	/*
	 * Pre: The user lands on a house tile and wants to buy a house Post: The user
	 * sells a house and loses money for it. Lets the player buy a property
	 */
	public void buyHouse() {
		
		Random number = new Random();
		Scanner userInput = new Scanner(System.in);
		int generated1 = number.nextInt(lines);
		int generated2;
		do {
			generated2 = number.nextInt(lines);
		} while (generated2 == generated1);
		System.out.println("You have a choice between two houses:");
		System.out.println("#1: " + selection[generated1]);
		System.out.println("#2: " + selection[generated2]);
		System.out.println("Enter 1 to choose #1 and 2 to chose #2, anything else to not buy a house.");
		String choice = userInput.next();
		userInput.nextLine();
		if (choice.equals("1")) {
			player.addProperty(selection[generated1]);
			System.out.println("You decided to buy " + selection[generated1].getName() + " for $"
					+ selection[generated1].getCost());
			System.out.println("LOSE: " + selection[generated1].getCost());
			player.removeMoney(selection[generated1].getCost());
		} else if (choice.equals("2")) {
			player.addProperty(selection[generated1]);
			System.out.println("You decided to buy " + selection[generated2].getName() + " for $"
					+ selection[generated2].getCost());
			System.out.println("LOSE: " + selection[generated2].getCost());
			player.removeMoney(selection[generated2].getCost());
		} else {
			System.out.println("You decided not to buy a house.");
		}
	}

	/*
	 * Pre: The house tile is initialized Post: Returns the number of lines in the
	 * houseTile.txt file Counts the number of lines in the file
	 */
	public int countLines() {
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

	/*
	 * Pre: It is the player's turn to move Post: Returns the name of the tile Gets
	 * the tile's name
	 */
	public String getTileName() {
		return ("House Tile");
	}
}
