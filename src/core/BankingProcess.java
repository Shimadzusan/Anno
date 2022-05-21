package core;

public class BankingProcess extends Thread implements Runnable {

	@Override
	public void run() {
		try {
			for (int j = 0; j < 200; j++) {
				Thread.sleep(1500);
				initLogocStreamExecution();	//..some stream execution
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	/** некоторое логическое воздействие на объект Bank*/
	private void initLogocStreamExecution() {
		Bank bank = new Bank();
		bank.doSomeThing();
		
		
	}
}
