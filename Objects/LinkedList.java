
import java.util.Scanner;
import java.util.Random;
/*
* Date: 2024-06-14
* Creates a list of the player's properties
*/
public class LinkedList {
	private Node head;
	
	// Constructor
	public LinkedList() {
		head = null;
	}
	
	// Modifier Methods
	
	/*
	 * Pre: A player buys a property they want to add to the list
	 * Post: A property is added to the list of properties owned by the player
	 * Adds a property to the linked list
	 */
	public void addToFront(Property n) {
		Node newNode = new Node(n);
		newNode.setNext(head);
		head = newNode;

	}
	
	/*
	 * Pre: A player sells a property
	 * Post: A property is removed from the list of properties owned by the player
	 * Removes a property to the linked list
	 */
	public int removeNode(String n) {
		Scanner input = new Scanner(System.in);
		Random number = new Random();
	    boolean listEmpty = head == null;
	    boolean nodeFound = false;
	    Node temp = head;
	    Node previous = null;
	    // Find the node to remove
	    while (temp != null && !nodeFound) {
	        if (temp.getName().equalsIgnoreCase(n)) {
	            nodeFound = true;
	        } else {
	            previous = temp;
	            temp = temp.getNext();
	        }
	    }
	    // Handle the removal if node found
	    if (nodeFound) {
	    	int generated = number.nextInt(250000)-100000;
	    	int sellPrice =  temp.getData().getCost() + generated;
	    	System.out.println("Someone is willing to buy your property for $" + sellPrice);
	    	System.out.println("You can reroll 1 time. Do you want to reroll to see if there's a better offer?");
	    	System.out.println("Enter 1 to reroll, anything else to go through with the deal:");
	    	String choice = input.next();
	    	input.nextLine();
	    	if (choice.equals("1")) {
	    		generated = number.nextInt(250000)-100000;
	    		sellPrice =  temp.getData().getCost() + generated;
	    		System.out.println("Someone is willing to buy your property for $" + sellPrice);
	    		System.out.println("You decided to sell your house");
	    	}
	    	
	    	
	    	
	        if (previous == null) { // If it is first
	            head = head.getNext(); // Removing the head node
	        } else { // if not first
	            previous.setNext(temp.getNext());
	        }
	      
	        return(sellPrice);
	    }
	    // Handle cases where the list is empty or node not found
	    if (listEmpty) {
	        System.out.println("You don't have any properties!");
	    } else if (!nodeFound) {
	        System.out.println("Could not find property!");
	        System.out.println("Enter its name again!");
	        String name = input.nextLine();
	        removeNode(name);
	      
	    }
	    return(0);
	}
	
	/*
	 * Pre: A player sells a property
	 * Post: A property is removed from the list of properties owned by the player
	 * Removes a property to the linked list
	 */
	public void removeNode(Property n) {
		Node temp = head;
		Node previous = null;
		boolean found = true;
		while (temp != null) {
			if (temp.getData().equals(n)) {
				found = true;
				break;
			} else {
				previous = temp;
				temp = temp.getNext();
			}
		}
		if (found != true) {
			System.out.println("Property not found in the list.");
		}
		// If the node to be removed is the head node
		if (previous == null) {
			head = head.getNext();
		} else { // set the head to the next node
			previous.setNext(temp.getNext());
		}
	}
	
	// Accessor Methods
	
	/*
	 * Pre: The player has retired and their asset value needs to be counted
	 * Post: Returns the value of the player's properties
	 * Gets the total value of the player's properties
	 */
	public int getTotal() {
		
		Node temp = head;
		
		int total = 0;
		
		while (temp != null) {
			
			total += temp.getData().getCost();
			
			temp = temp.getNext();
		}
		
		return total;
	}
	
	
	/*
	 * Pre: Checks if the player owns any properties
	 * Post: Returns true if the player has not bought any properties
	 * Checks if the user owns any properties
	 */
	public boolean isEmpty() {
		if (head == null) {
			return(true);
		} else {
			return(false);
		}
	}
	
	/*
	 * Pre: The player wants to see their properties
	 * Post: The player's properties are displays
	 * Displays properties owned by player
	 */
	public String toString() {
		Node temp = head;
		
		if (head == null) {
			
			return "No properties";
		} else {
			
			String info = "";
			while (temp != null) {
				info += temp.getData().getName() + ", " + temp.getData().getCost();
				temp = temp.getNext();
			}
			return info;
		}
		
	}
	
	/*
	 * Pre: A linked list class is made
	 * Post: The user can now add properties to a list
	 * Allows the user to add proeprties to a linked list
	 */
	private class Node {
		
		private Property data;
		// recursive link
		private Node next;
		// constructor to make a node
		private Node(Property a) {
			data = a;
			next = null;
		}
		// get the information stored
		private Property getData() {
			return data;
		}
		private String getName() {
			return(data.getName());
		}
		// get the next node
		private Node getNext() {
			return next;
		}
		// set the next node
		private void setNext(Node n) {
			next = n;
		}
	}
}



