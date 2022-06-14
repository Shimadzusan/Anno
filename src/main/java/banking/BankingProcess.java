package banking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankingProcess extends Thread implements Runnable {

	private static final Logger LOG = LogManager.getLogger(BankingProcess.class);
	Bank bn;
	@Override
	public void run() {
		
		LOG.info("begin BankingProcess");
		try {
			bn = new Bank();
			bn.uploadData();
			for (int j = 0; j < 200; j++) {
				Thread.sleep(1500);
				initLogicStreamExecution();	//..some stream execution
			}
			bn.downloadData();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOG.info("end BankingProcess");
	}

	/** некоторое логическое воздействие на объект Bank */
	private void initLogicStreamExecution() throws FileNotFoundException, IOException {
//		Bank bn = new Bank();
//		bn.uploadData();
		Random randomNumber = new Random();
		int x = randomNumber.nextInt(1001, 1200);
		int y = randomNumber.nextInt(1001, 1200);
		int z = randomNumber.nextInt(100);
		bn.executeTransaction(x + "", y + "", z);
		System.out.println("..executeTransaction");
//		bn.downloadData();
	}
}
