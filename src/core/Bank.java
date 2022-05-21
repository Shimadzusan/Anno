package core;

import java.util.HashMap;

public class Bank {
	String account;
	int amount;
	HashMap<String, Integer> reserves = new HashMap<String, Integer>();
	
	void doSomeThing() {
		System.out.println("..banking ..banking");
	}
}
