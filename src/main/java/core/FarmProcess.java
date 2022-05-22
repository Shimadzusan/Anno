package core;

public class FarmProcess extends Thread implements Runnable {

	@Override
	public void run() {
		try {
			for (int j = 0; j < 100; j++) {
				Thread.sleep(2500);
				initLogocStreamExecution();	//..some stream execution
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	 /** некоторое логическое воздействие на объект Farm*/
	private void initLogocStreamExecution() {
		Farm farm = new Farm();
		farm.growthAgriculture();
		
	}
}
