// Author: Cameron Gomke
// File Name: Transaction
// Purpose: CleverBudget
// Date Created: 10/30/2017
public class Transaction {

	//Attributes:
	private String name;
	private double amount;
	private String date;
	private double sender;
	private double receiver;
	private String type;
	
	//Getters and Setters:
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getDate() {
		return date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSender() {
		return sender;
	}
	public void setSender(double sender) {
		this.sender = sender;
	}
	public double getReceiver() {
		return receiver;
	}
	public void setReceiver(double receiver) {
		this.receiver = receiver;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
