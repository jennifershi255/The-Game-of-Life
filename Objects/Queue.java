
/*
* Date: 2024-06-14
* Queues up the players for their turn to play
*/
public class Queue {
	// instance variables
	private Player[] data;
	private int rear; // index
	
	// Constructor
	public Queue(int n) {
		data = new Player[n];
		rear = 0;
	}
	// check if queue is full
	public boolean isFull() {
		if (rear == data.length) {
			return true;
		} else {
			return false;
		}
	}
	// check if queue is empty
	public boolean isEmpty() {
		if (rear == 0) {
			return true;
		} else {
			return false;
		}
	}
	// add n to rear of queue
	public void enqueue(Player n) {
		if (isFull() == true) {
			System.out.print("Queue is full. Increase queue size");
		} else {
			data[rear] = n;
			rear++;
		}
	}
	// number of items in queue
	public int size() {
		return rear;
	}
	// look at front item
	public Player front() {
		if (isEmpty() == true) {
			System.out.print("Queue is empty. add to queue");
			return null;
		} else {
			return data[0];
		}
	}
	// removing items from queue
	public Player dequeue() {
		if (isEmpty() == true) {
			System.out.print("Queue is empty. add to queue");
			return null;
			
		} else {
		}
		Player temp = data[0]; // stores front to return
		for (int i = 1; i < rear; i++) {
			data[i - 1] = data[i];
		}
		
		rear--;
		return temp;
	}
	// clear the queue
	public void makeEmpty() {
		rear = 0;
	}
	
	// Displays the list of players in their turn order
	public String toString() {
		
		String info = "";
		
		for (int i = 0; i < rear; i ++) {
			
			info += data[i].getName() + ", ";
		}
		
		return info;
	}
}



