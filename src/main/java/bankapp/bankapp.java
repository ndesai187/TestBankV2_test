package bankapp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import bank.mmTrade;
import bank.tradeConf;
import bank.ITrade;
import bank.tradeHandler;
//import bank.tradeData;
// test for github
// test for github
public class bankapp {

	public static void main(String[] args) {
		float amount;
		int i = 0;
		String control = "init";                       	// control char for trade input loop 
		StringBuilder display = new StringBuilder(""); 	// String variable for prompt 
		Scanner ip = new Scanner(System.in);			// Scanner object for user input
		mmTrade[] trade = new mmTrade[10];				// mmTrade object instantiate
		// Interface + anonymous class definition
		ITrade t = new ITrade(){
			public void showModHistory(){
				for(int i = 0; i < 100; i++) System.out.printf("-");
				System.out.println("\nAnonymous class exe, defining modhistory for bankapp program");	
				System.out.println("Application 'bankapp' was last modified @ 14 Jun 2015, 5:58 PM");
				for(int i = 0; i < 100; i++) System.out.printf("-");
			}
		};
		
		do {
			trade[i] = new mmTrade();
			tradeConf a = new tradeConf();
			System.out.println(trade[i]);
			
			// Trade booking
			trade[i].enterTrade();
			
			// Confirmation processing
			amount = trade[i].calcTotal();
			a.mmConfprint(trade[i], amount);
			
			// Trade save in file
			tradeHandler.storeTrade(trade[i]);
			
			display.append(trade[i].getRef() + " , ");
			System.out.println("Press / to stop booking : ");
			control = ip.nextLine();
			i++;

		} while ((!control.equals("/")) && (i < 5));
		
		System.out.printf("Trades booked with ref : ");
		System.out.println(display.toString());
		
		System.out.println("Do you want to search a Trade? (Y/N) ");
		control = ip.nextLine();
		
		// Loop doesn't function properly. file needs to be re-opened for every search.
		while(control.equals("Y") || control.equals("y")){
			
			System.out.println("Enter Trade reference : ");
			control = ip.nextLine();
			tradeHandler.fetchTrade(control);
			
			System.out.println("Do you want to search a Trade? (Y/N) ");
			control = ip.nextLine();	
		};
		
		t.showModHistory();
		System.out.println("\nProgram Terminated @ local time :: " + new SimpleDateFormat("dd-MMM-yyyy , HH:mm:ss").format(Calendar.getInstance().getTime()));
		System.out.println(Calendar.getInstance().getTime());
		ip.close();
		
	}

}
