package core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

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
}
