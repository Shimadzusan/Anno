package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import util.DataOperation;

public class Bank {
	String account;
	int amount;
	HashMap<String, Integer> reserves = new HashMap<String, Integer>();
	
	/**payee. payer. consumer*/
	void doSomeThing() {
		System.out.println("..banking ..banking");
	}
	
	/**.. клиент 1123 переводит средства клиенту 1125 сумма 5 руб.*/
	void executeTransaction(String sender, String reciever, int amount) {
		reserves.put(sender, reserves.get(sender) - amount);
		reserves.put(reciever, reserves.get(reciever) + amount);
	}
	
	void uploadData() throws FileNotFoundException, IOException {
		String s = new DataOperation().readDataFromFile("C:\\Users\\tokug\\eclipse-workspace\\Anno\\balance.txt");
		String[] sArray = s.split("\n");
		for (int i = 0; i < sArray.length; i++) {
			String[] s2 = sArray[i].split(":");
			reserves.put(s2[0], Integer.parseInt(s2[1]));
		}
	}
	
	void downloadData() throws IOException {
		String data = "";
		for(HashMap.Entry<String, Integer> item : reserves.entrySet()) {
			data = data + item.getKey() + ":" +  item.getValue() + "\n";
			new DataOperation().writeDataToFile("C:\\Users\\tokug\\eclipse-workspace\\Anno\\balance.txt", data);
		}
	}
	
	void openAccount() {}
	void closeAccount() {}
	void balanceAccount() {}
}
