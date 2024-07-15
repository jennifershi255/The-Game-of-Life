// sets them players job
import java.util.Random;
import java.util.Scanner;

public class CareerTile extends Tile{
	Job[] degree;
	Job[] noDegree;
	private static Job[] taken;
	Random number = new Random();

	// Constructor
	public CareerTile(Player player, int numOfPlayers) {
		super(player);
		taken = new Job[numOfPlayers*2];
		degree = new Job[6];
		degree[0] = new Job("Sustainability Researcher", 70000, 15000, true);
		degree[1] = new Job("Environmental Health Scientist", 80000, 20000, true);
		degree[2] = new Job("Urban planner", 70000, 30000, true);
		degree[3] = new Job("Environmental engineer", 120000, 35000, true);
		degree[4] = new Job("Environmental policy analyst", 90000, 40000, true);
		degree[5] = new Job("Conservation Scientist", 100000, 45000, true);
		noDegree = new Job[6];
		noDegree[0] = new Job("Recycling worker", 50000, 5000, false);
		noDegree[1] = new Job("Farm workers", 50000, 20000, false);
		noDegree[2] = new Job("Wind turbine technician", 70000, 15000, false);
		noDegree[3] = new Job("Safety Coordinator", 60000, 10000, false);
		noDegree[4] = new Job("Green Construction worker", 60000, 25000, false);
		noDegree[5] = new Job("Waste Management Worker", 60000, 10000, false);
	}
	
	
	// Modifier Methods
	
	/*
	 * Pre: The player chooses whether they want to go to college
	 * Post: They get a job based on their education level
	 * Gives the player a random job based on their education level
	 */
	public void setFirstJob(boolean wentToCollege) {

		boolean took = false;
		while (took != true ) {
			
			int num = number.nextInt(6);
			Job selectedJob;
			
			if (wentToCollege) {
				 selectedJob = degree[num];
			} else {
				 selectedJob = noDegree[num];
			}
			

			// Check if the job is already taken
			boolean isTaken = false;
			for (int i = 0; i < taken.length; i++) {
				if (taken[i] == selectedJob) {
					isTaken = true;
					break;
				}
			}

			// If the job is not taken, assign it and mark it as taken
			if (isTaken != true) {
				player.getJob().setSalary(selectedJob.getSalary());
				player.getJob().setTitle(selectedJob.getTitle());
				player.getJob().setTaxes(selectedJob.getTaxes());

				for (int i = 0; i < taken.length; i++) {
					if (taken[i] == null) {
						taken[i] = selectedJob;
						break;
					}
				}
				took = true;
			}
		}

		
		if (wentToCollege) {
			player.setTileIndex(1);
		} else {
			player.setTileIndex(0);
		}
		
		

	}
	
	/*
	 * Pre: The player lands on a career tile
	 * Post: The player chooses between 2 jobs to switch to
	 * The player changes their job
	 */
	public void setJobWithChoice() {

		boolean wentToCollege = player.getJob().getEducation();
		
		Scanner input = new Scanner(System.in);
		Job selectedJob1;
		Job selectedJob2;

		boolean isTaken = false;
		do {
			
			do {
				int num = number.nextInt(6);
				
				if (wentToCollege) {
					selectedJob1 = degree[num];
				} else {
					selectedJob1 = noDegree[num];
				}
				
				isTaken = false;
				for (int i = 0; isTaken == false && i < taken.length; i++) {
					if (taken[i] == selectedJob1) {
						isTaken = true;
					}
				}

			} while (isTaken == true );
			
			isTaken = false;

			do {
				int num = number.nextInt(6);
				if (wentToCollege) {
					selectedJob2 = degree[num];
				} else {
					selectedJob2 = noDegree[num];
				}

				isTaken = false;
				for (int i = 0; isTaken == false && i < taken.length; i++) {
					if (taken[i] == selectedJob2 || taken[i] == selectedJob1) {
						isTaken = true;
					}
				}

			} while (isTaken == true);
			
		} while (selectedJob1 == selectedJob2);
		

		System.out.println("You can choose between two jobs:");
		System.out.println("Job #1:" + selectedJob1);
		System.out.println("Job #2:" + selectedJob2);

		System.out.println("Enter 1 to choose job #1, enter 2 to choose job #2");
		String choice = input.next();
		input.nextLine();
		while (!(choice.equals("1") || choice.equals("2"))) {
			System.out.println("Enter 1 or 2!");
			choice = input.next();
			input.nextLine();
		}

		// If the job is not taken, assign it and mark it as taken
		
		boolean took = false;
		if (choice.equals("1")) {
			player.getJob().setSalary(selectedJob1.getSalary());
			player.getJob().setTitle(selectedJob1.getTitle());
			player.getJob().setTaxes(selectedJob1.getTaxes());

			for (int i = 0; took == false && i < taken.length; i++) {
				if (taken[i] == null) {
					taken[i] = selectedJob1;
					took = true;
				}
			}

		} else {
			player.getJob().setSalary(selectedJob2.getSalary());
			player.getJob().setTitle(selectedJob2.getTitle());
			player.getJob().setTaxes(selectedJob2.getTaxes());

			for (int i = 0; took == false && i < taken.length; i++) {
				if (taken[i] == null) {
					taken[i] = selectedJob2;
					took = true;
				}
			}
			
		

		}
		
		System.out.println(player.getName() + " is now a " + player.getJob().getTitle() + "!");

	}
	
	/*
	 * Pre: The player lands on a career tile and chooses a pay raise
	 * Post: The player'salary increases by a random amount
	 * The player gets a pay raise
	 */
	public void payRaise() {
		int raise = number.nextInt(3);
		raise = raise * 10000;
		player.getJob().raiseSalary(raise);
		System.out.println("You got a pay raise of $" + raise);
		System.out.println("Your salary is now $" + player.getJob().getSalary());
	}
	
	// Accessor method
	/*
	 * Pre: It is the player's turn to move 
	 * Post: Returns the name of the tile
	 * Gets the tile's name
	 */
	public String getTileName() {
		return("Career Tile");
	}
	
}

