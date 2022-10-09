package logistic;

import java.io.FileNotFoundException;
import java.io.IOException;

import util.DataOperation;

public class Warehouse {
	int ware = 0;
	int coins = 100;
	
	public Warehouse() throws FileNotFoundException, IOException {
		String s = new DataOperation().readDataFromFile("C:\\\\Users\\\\worker\\\\eclipse-workspace\\\\Anno\\\\warehouse.txt");
		String s2 = s.replaceAll("\n", "");
		ware = Integer.parseInt(s2);
	}
	
	public int getWare() {
		return ware;
	}
	
	public void setWare(int ware) throws IOException {
		this.ware = ware;
			
		System.out.println("ware: " + this.ware + " / " + ware);
		new DataOperation().writeDataToFile("C:\\Users\\worker\\eclipse-workspace\\Anno\\warehouse.txt", (this.ware + ""));
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void setCoins(int coins) {
		this.coins = coins;
	}
}
