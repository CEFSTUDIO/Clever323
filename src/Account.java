// Author: Cameron Gomke
// File Name: Account
// Purpose: CleverBudget
// Date Created: 10/30/2017
// Last Updated: 11/27/2017
public class Account {

	//Attributes:
	private String firstName;
	private String lastName;
	private double startingBalance;
	private String description;
	private String phoneNumber;
	private String email;
	
	//Getters and Setters:
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getStartingBalance() {
		return startingBalance;
	}

	public void setStartingBalance(double startingBalance) {
		this.startingBalance = startingBalance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "First Name: " + firstName + ", Last Name: " + lastName + ", Starting Balance: " + startingBalance
				+ ", Account Description: " + description + ", Phone Number: " + phoneNumber + ", email: " + email + "\n";
	}

	
	
	
}
