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
	
	void someMethod() {
		reserves.put("123", 125);
		reserves.put("124", 125);
		reserves.put("125", 100);
		reserves.put("126", 125);
		
//		for(HashMap.Entry<String, Integer> item : reserves.entrySet()) {
//			//System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
//			System.out.println("Key: " +  item.getKey() + " " +  item.getValue());
//		}
//		
//		//System.out.println(reserves.remove("124"));
//		
		for(HashMap.Entry<String, Integer> item : reserves.entrySet()) {
			//System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
			System.out.println("Key: " +  item.getKey() + " " +  item.getValue());
		}
	}
	
	/**..for data generation*/
	void someMethod2() {
		for (int i = 0; i < 1000; i++) {
			Random randomNumber = new Random();
			int x = randomNumber.nextInt(100);
			System.out.println(1000 + i + ":" + x);
		}
	}
	
	/**.. клиент 1123 переводит средства клиенту 1125 сумма 5 руб.*/
	void executeTransaction(String sender, String reciever, int amount) {
		System.out.println(reserves.get(sender) - amount);
		System.out.println(reserves.get(reciever) + amount);
		
		reserves.put(sender, reserves.get(sender) - amount);
		reserves.put(reciever, reserves.get(reciever) + amount);
		
		for(HashMap.Entry<String, Integer> item : reserves.entrySet()) {
		//System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
		System.out.println("Key: " +  item.getKey() + " " +  item.getValue());
		}
	}
	
	void uploadData() throws FileNotFoundException, IOException {
		String s = new DataOperation().readDataFromFile("C:\\Users\\tokug\\eclipse-workspace\\Anno\\balance.txt");
		String[] sArray = s.split("\n");
		System.out.println(sArray.length);
		System.out.println(sArray[5]);
		for (int i = 0; i < sArray.length; i++) {
			String[] s2 = sArray[i].split(":");
			reserves.put(s2[0], Integer.parseInt(s2[1]));
		}
	}
	
	void downloadData() throws IOException {
		String data = "";
		for(HashMap.Entry<String, Integer> item : reserves.entrySet()) {
			//System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
			System.out.println(item.getKey() + ":" +  item.getValue());
			data = data + item.getKey() + ":" +  item.getValue() + "\n";
			new DataOperation().writeDataToFile("C:\\Users\\tokug\\eclipse-workspace\\Anno\\balance.txt", data);
		}
	}
}
