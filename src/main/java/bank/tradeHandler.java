package bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
// test for github
public class tradeHandler implements ITrade {

	public static void storeTrade(mmTrade trade) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("Trades.ser", true);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(trade);
			oos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
	}
	
	public static void fetchTrade(String tradeRef){
		FileInputStream fis;
		ObjectInputStream ois = null;
		mmTrade trade = null;
		//int i = 1;
		try {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
			fis = new FileInputStream("Trades.ser");
			ois = new ObjectInputStream(fis);
			//mmTrade trade1 = (mmTrade) ois.readObject();
			do{
				trade = (mmTrade) ois.readObject();
			}while(!tradeRef.equals(trade.getRef()));
			
			System.out.println("This trade was booked with : " + "Ref = " + trade.getRef() + " ,Customer = " + trade.getRate());
			
			System.out.println(trade);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void showModHistory() {
		// TODO Auto-generated method stub
		
	}

}
