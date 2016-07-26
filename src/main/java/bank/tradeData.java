package bank;

import java.io.Serializable;
// test for github

public abstract class tradeData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String tradeRef;
	private String cust;
	private String branch = "Vadodara";
	public static int totalTrades = 0;
	private final static String BANKNAME = "DESAI BANK";

	public void setBr(String text){
		if(!text.equals("")) {
				branch = text;
		}
	}
	
	public String getBr(){
		return branch;
	}
	
	public void setRef(String text){
		tradeRef = text;
	}
	
	public String getRef(){
		return tradeRef;
	}
	
	public void setCust(String text){
		cust = text;
	}
	
	public String getCust(){
		return cust;
	}
	
	public String toString(){
		StringBuilder object = new StringBuilder();
		object.append("executing trade number : " + totalTrades);
		
		return object.toString();
	}
	
	public tradeData() {
		System.out.println("You are trading for " + BANKNAME);
		System.out.println("ENTER TRADE DETAILS");
		totalTrades++;
	}

	public tradeData(String dash, int no) {
		this();
	}
	
	//abstract method, must create body for this in all child classes
	public abstract void enterTrade();
	
	//method to store trade, must be inherited by child classes
	//public void storeTrade()
	
}
