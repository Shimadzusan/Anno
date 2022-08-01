package banking;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import util.DataOperation;

public class Bank {
	private static final Logger LOG = LogManager.getLogger(Bank.class);
	String account;
	int amount;
	private int totalAmount;
	
	BankArray bankArray;
	//Map or List
	HashMap<String, ClientAccount> poolAccounts = new HashMap<String, ClientAccount>();	// new main object
	
	/**payee. payer. consumer*/
	void doSomeThing() {
		System.out.println("..banking ..banking");
		//poolAccounts.containsKey(LOG);
	}
	
	/**.. клиент 1123 переводит средства клиенту 1125 сумма 5 руб.*/
	public void executeTransaction(String sender, String reciever, int amount) {
		
		/* poolAccounts */
		ClientAccount payer = poolAccounts.get(sender);
		payer.setAmount(payer.getAmount() - amount);
		poolAccounts.put(sender, payer);
		
		ClientAccount payee = poolAccounts.get(reciever);
		payee.setAmount(payee.getAmount() + amount);
		poolAccounts.put(reciever, payee);
		
	}
	
	/** initialization main object "reserves"/"poolAccounts" from file an the disk */
	public void uploadData() throws FileNotFoundException, IOException {
		/* poolAccounts */
		//System.out.println("poolAccounts");
		
		Gson gson = new Gson();
		String s = new DataOperation().readDataFromFile("C:\\Users\\worker\\eclipse-workspace\\Anno\\poolAccounts.json");
		bankArray = gson.fromJson(s, BankArray.class);

		for (int i = 0; i < bankArray.getBankArray().size(); i++) {
			ClientAccount clientAccount = bankArray.getBankArray().get(i);	
			poolAccounts.put(clientAccount.getAccontNumber(), clientAccount);
		}

		LOG.info("poolAccounts upload successful, size: " + poolAccounts.size());
	}
	
	/** download data from main object to file an the disk */
	public void downloadData() throws IOException {
		
		/* poolAccounts */
		Gson gson = new Gson();
		List<ClientAccount> listClientAccount = new ArrayList();
		
		for(HashMap.Entry<String, ClientAccount> item : poolAccounts.entrySet()) {
			listClientAccount.add(item.getValue());
			//System.out.println("*** " + item.getValue().getAmount());
			totalAmount = totalAmount + item.getValue().getAmount();
		}
		
		bankArray.setBankArray(listClientAccount);
		String jsonInString = gson.toJson(bankArray);
		new DataOperation().writeDataToFile("C:\\Users\\worker\\eclipse-workspace\\Anno\\poolAccounts.json", jsonInString);
		LOG.info("poolAccounts download successful, size: " + poolAccounts.size() + " totalAmount: " + totalAmount);
	}
	
	void openAccount() {
		System.out.println("openAccount..");
		
	}
	void closeAccount() {
		System.out.println("closeAccount..");
	}
	
	void balanceAccount() {}
	
	/**.. клиент 1123 вносит средства, сумма 5 руб.*/
	void depositCash(String account, int amount) {
		System.out.println("depositCash..");
		
		ClientAccount payer = poolAccounts.get(account);
		payer.setAmount(payer.getAmount() + amount);
		poolAccounts.put(account, payer);
	}
	
	/**.. клиент 1123 выводит средства, сумма 5 руб.*/
	void withdrawalCash(String account, int amount) {
		System.out.println("withdrawalCash..");
		
		ClientAccount payer = poolAccounts.get(account);
		payer.setAmount(payer.getAmount() - amount);
		poolAccounts.put(account, payer);
	}
}
