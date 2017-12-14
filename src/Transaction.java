//Author(s): Cameron Gomke, Cheyanne Flickinger
//File Name: Transaction (Class)
//Purpose: CleverBudget
//Date Created: 10/30/2017
//Last Updated: 12/12/2017
public class Transaction {

	//Attributes:
	private String name;
	private double amount;
	private String date;
	private String depositOrWithdraw;
	private String type;
	private String toOrFrom;
	private String code;
	private int tranNum;
	
	//Getters and Setters:
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDepositOrWithdraw() {
		return depositOrWithdraw;
	}
	public void setDepositOrWithdraw(String depositOrWithdraw) {
		this.depositOrWithdraw = depositOrWithdraw;
	}
	public String getToOrFrom() {
		return toOrFrom;
	}
	public void setToOrFrom(String toOrFrom) {
		this.toOrFrom = toOrFrom;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
	public int getTranNum() {
		return tranNum;
	}
	public void setTranNum(int tranNum) {
		this.tranNum = tranNum;
	}
	
	
	
	

}
