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
	
	BankArray bankArray;
	//Map or List
	HashMap<String, ClientAccount> poolAccounts = new HashMap<String, ClientAccount>();	// new main object
	HashMap<String, Integer> reserves = new HashMap<String, Integer>();	// old main object
	
	/**payee. payer. consumer*/
	void doSomeThing() {
		System.out.println("..banking ..banking");
	}
	
	/**.. клиент 1123 переводит средства клиенту 1125 сумма 5 руб.*/
	public void executeTransaction(String sender, String reciever, int amount) {
//		reserves.put(sender, reserves.get(sender) - amount);
//		reserves.put(reciever, reserves.get(reciever) + amount);
		
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
		/* reserves */
//		String s = new DataOperation().readDataFromFile("C:\\Users\\tokug\\eclipse-workspace\\Anno\\balance.txt");
//		String[] sArray = s.split("\n");
//		for (int i = 0; i < sArray.length; i++) {
//			String[] s2 = sArray[i].split(":");
//			reserves.put(s2[0], Integer.parseInt(s2[1]));
//		}
		
		/* poolAccounts */
		//System.out.println("poolAccounts");
		
		Gson gson = new Gson();
		String s = new DataOperation().readDataFromFile("C:\\Users\\tokug\\eclipse-workspace\\Anno3\\Anno\\poolAccounts.json");
		bankArray = gson.fromJson(s, BankArray.class);

		for (int i = 0; i < bankArray.getBankArray().size(); i++) {
			ClientAccount clientAccount = bankArray.getBankArray().get(i);	
			poolAccounts.put(clientAccount.getAccontNumber(), clientAccount);
		}

		LOG.info("poolAccounts upload successful, size: " + poolAccounts.size());
	}
	
	/** download data from main object to file an the disk */
	public void downloadData() throws IOException {
//		String data = "";
//		for(HashMap.Entry<String, Integer> item : reserves.entrySet()) {
//			data = data + item.getKey() + ":" +  item.getValue() + "\n";
//			new DataOperation().writeDataToFile("C:\\Users\\tokug\\eclipse-workspace\\Anno\\balance.txt", data);
//		}
		
		/* poolAccounts */
		Gson gson = new Gson();
		List<ClientAccount> listClientAccount = new ArrayList();
		
		for(HashMap.Entry<String, ClientAccount> item : poolAccounts.entrySet()) {
			listClientAccount.add(item.getValue());
		}
		
		bankArray.setBankArray(listClientAccount);
		String jsonInString = gson.toJson(bankArray);
		new DataOperation().writeDataToFile("C:\\Users\\tokug\\eclipse-workspace\\Anno3\\Anno\\poolAccounts.json", jsonInString);
		LOG.info("poolAccounts download successful, size: " + poolAccounts.size());
	}
	
	void openAccount() {}
	void closeAccount() {}
	void balanceAccount() {}
}
