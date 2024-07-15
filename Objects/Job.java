
/*
* Date: 2024-06-10
* Sets the player's job and information related to their job
*/
public class Job {
	Job[] degree;
	Job[] noDegree;
	private int salary;
	private int taxes;
	private String title;
	private boolean wentToCollege;
	// Constructor
	public Job(String jobTitle, int jobSalary, int jobTaxes, boolean newWentToCollege) {
		title = jobTitle;
		salary = jobSalary;
		taxes = jobTaxes;
		wentToCollege = newWentToCollege;
	}
	
	// Modifier methods
	/*
	 * Pre: The user gets a job and gets a salary
	 * Post: The player's salary for their job is set
	 * Sets the player's salary
	 */
	public void setSalary(int newSalary) {
		salary = newSalary;
	}
	/*
	 * Pre: The user gets a job
	 * Post: The player's taxes for their job is set
	 * Sets the player's taxes
	 */
	public void setTaxes(int newTaxes) {
		taxes = newTaxes;
	}
	
	/*
	 * Pre: The user gets a job
	 * Post: The player's job title is set
	 * Sets the player's job title
	 */
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	/*
	 * Pre: The user lands on a career tile and chooses a raise
	 * Post: The player's salary is increased
	 * Increases the player's salary
	 */
	public void raiseSalary(int amount) {
		salary += amount;
	}
	
	// Accessor Methods
	/*
	 * Pre: The player wants to know their job name
	 * Post: Returns the name of their job
	 * Displays the player's job
	 */
	public String getTitle() {
		return title;
	}
	/*
	 * Pre: The player has a job
	 * Post: Returns the player's salary
	 * Gets the player's salary
	 */
	public int getSalary() {
		return salary;
	}
	/*
	 * Pre: The player has a job
	 * Post: Returns the player's taxes
	 * Gets the player's taxes amount
	 */
	public int getTaxes() {
		return taxes;
	}
	
	/*
	 * Pre: The player chooses their education
	 * Post: Returns true if the player went to college
	 * Gets the player's education level
	 */
	public boolean getEducation() {
		return(wentToCollege);
	}
	
	/*
	 * Pre: It is the player's turn to move
	 * Post: Returns the name of the tile
	 * Gets the tile's name
	 */
	public String toString() {
		String info;
		info = "Job: " + getTitle() + ", Salary: $" + getSalary() + ", Taxes: $" + getTaxes();
		return info;
	}
}



