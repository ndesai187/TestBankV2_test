package bank;

import java.io.Serializable;
import java.util.Scanner;
// test for github

public class mmTrade extends tradeData implements ITrade,Serializable{
	
	private static final long serialVersionUID = 1L;
	private float rate;
	private float notional;
	private float totalAtMaturity;
	private int tenure;
	private int noOfDays;
	// Declare scanner object transient as the class is serializable. Scanner object in normal form will give error while writing object.
	// other way is to transfer declaration inside method.
	private transient Scanner input = new Scanner(System.in);
	
	public int getTenure() {
		return tenure;
	}
	
	public float getRate(){
		return rate;
	}
	
	public float getNotional(){
		return notional;
	}
	
	public int getDays(){
		return noOfDays;
	}
	
	/*
	public String getRef(){
		return "polymorphism";
	}
	*/
	
	public void enterTrade() {
		
		System.out.println("Enter Branch (default Vadodara branch) : ");
		this.setBr(input.nextLine());
		
		System.out.println("Enter Trade Reference : ");
		this.setRef(input.nextLine());

		System.out.println("Enter Customer : ");
		this.setCust(input.nextLine());
		
		System.out.println("Enter Rate : ");
		rate = input.nextFloat();
		
		System.out.println("Enter Principal Amount : ");
		notional = input.nextFloat();
		
		System.out.println("Enter Loan Tenure (in years) : ");
		tenure = input.nextInt();
		
		System.out.println("Enter day count fraction : ");
		noOfDays = input.nextInt();
		
	}
	
	
	public float calcTotal() {
		totalAtMaturity = notional * tenure * rate / 100;
		return notional + totalAtMaturity;
	}
	
	public void showModHistory(){
		System.out.println("mmTrade Class : Created by Nirav : last modified 13 Jun 2015");
	}
}