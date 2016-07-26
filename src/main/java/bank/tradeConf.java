package bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
// test for github

public class tradeConf implements ITrade, Serializable{
	
	private static final long serialVersionUID = 1L;

	// Print Confirmations in text file
	public void mmConfprint (mmTrade trade, float maturityAmount){
		
		File conffile = new File("conffile.txt");
		
		BufferedWriter conftxt = null;
		try {
			conftxt = new BufferedWriter(new FileWriter(conffile,true));
			conftxt.write(generateConf(trade, maturityAmount));
			conftxt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Looping method to create pattern for header and footer
	private String printDes(String text, int no) {
		StringBuilder pattern = new StringBuilder();
		
		for (int i = 1; i < no; i++) pattern.append(text); 

		System.out.printf(pattern.toString() + "\n");
		pattern.append("\n");
		return pattern.toString();
	}
	
	//Method to create consolidate confirmation text
	private String generateConf(mmTrade trade, float maturityAmount) {
		
		StringBuilder concateconf = new StringBuilder();
		concateconf.append(printDes("-", 120) + printDes(" ", 45) + "\bTRADE CONFIRMATION\n" + printDes("-", 120));
		concateconf.append("Hello! " + trade.getCust() + ",\n" + "Your loan , with reference " + trade.getRef() );
		concateconf.append(", is issued from " + trade.getBr() + " branch for " + trade.getTenure() + " year/years, " );
		concateconf.append("with interest " + trade.getRate() + "% and amount of " + trade.getNotional() + "/-\n");
		concateconf.append("Interest will be calculated with " + trade.getDays() + " days a year basis.\n");
		concateconf.append("You have to pay " + maturityAmount + " after " + trade.getTenure() + " year/years\n");
		concateconf.append(printDes("~", 120) + "Total trades booked : " + tradeData.totalTrades + "\n" + printDes("~", 120));
		concateconf.append("\n" + Calendar.getInstance().getTime() + "\n");
		return concateconf.toString();
	}
	
	//Interface implementation method, a more can be done to expand interface, no ideas as of now
	public void showModHistory(){
		System.out.println("tradeConf Class : Created by Nirav : last modified 13 Jun 2015");
	}
	
}	












		/*
		printDes("-", 120);
		printDes("						TRADE CONFIRMATION", 2);
		printDes("-", 120);

		System.out.println("Hello! " + trade.getCust() + ",");
		System.out.println("Your loan , with reference " + trade.getRef()
				+ ", is issued from " + trade.getBr() + " branch for " + trade.getTenure() + " year/years, "
				+ "with interest " + trade.getRate() + "% and amount of " + trade.getNotional()
				+ "/-");
		System.out.println("Interest will be caluclated with " + trade.getDays()
				+ " days a year basis");
		
		System.out.println("You have to pay " + maturityAmount + " after "
				+ trade.getTenure() + " year/years");
		printDes("~", 120);
		System.out.println("Total trades booked : " + tradeData.totalTrades);
		printDes("~", 120);
		*/

