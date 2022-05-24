package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class BankingProcess extends Thread implements Runnable {

	@Override
	public void run() {
			
		try {
			for (int j = 0; j < 200; j++) {
				Thread.sleep(1500);
				initLogicStreamExecution();	//..some stream execution
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/** некоторое логическое воздействие на объект Bank */
	private void initLogicStreamExecution() throws FileNotFoundException, IOException {
		Bank bn = new Bank();
		bn.uploadData();
		Random randomNumber = new Random();
		int x = randomNumber.nextInt(1001, 1200);
		int y = randomNumber.nextInt(1001, 1200);
		int z = randomNumber.nextInt(100);
		bn.executeTransaction(x + "", y + "", z);
		System.out.println("..executeTransaction");
		bn.downloadData();
	}
}
