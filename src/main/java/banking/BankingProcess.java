package banking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import core.ConfigurationModule;

public class BankingProcess extends Thread implements Runnable {

	private static final Logger LOG = LogManager.getLogger(BankingProcess.class);
	Bank bank;
	
	@Override
	public void run() {
		LOG.info("begin BankingProcess");
		try {
			bank = new Bank();
			bank.uploadData();
			for (int j = 0; j < ConfigurationModule.bankingProcessIteration; j++) {
				Thread.sleep(ConfigurationModule.bankingProcessFrequency);
				//initLogicStreamExecution();	//..some stream execution
			}
			bank.downloadData();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOG.info("end BankingProcess");
	}

	/** некоторое логическое воздействие на объект Bank */
//	private void initLogicStreamExecution() throws FileNotFoundException, IOException {
////		Bank bank = new Bank();
////		bank.uploadData();
//		Random randomNumber = new Random();
//		int x = randomNumber.nextInt(1001, 1200);
//		int y = randomNumber.nextInt(1001, 1200);
//		int z = randomNumber.nextInt(100);
//
//		if(z <= 70) {
//		bank.executeTransaction(x + "", y + "", z);
//		System.out.println("..executeTransaction");
//		}
//
//		if(z > 70 && z <= 75) {
//			bank.openAccount();
//		}
//
//		if(z > 75 && z <= 80) {
//			bank.closeAccount();;
//		}
//
//		if(z > 80 && z <= 90) {
//			bank.depositCash(y + "", randomNumber.nextInt(100));;
//		}
//
//		if(z > 90 && z <= 100) {
//			bank.withdrawalCash(y + "", randomNumber.nextInt(100));
//		}
////		bank.downloadData();
//	}
//
	/** некоторое логическое воздействие на объект Bank */
	private void actionLogicStreamExecution() throws FileNotFoundException, IOException {}
	
	/** некоторое логическое воздействие на объект Bank */
	private void endLogicStreamExecution() throws FileNotFoundException, IOException {}
	
}
