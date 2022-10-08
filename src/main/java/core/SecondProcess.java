package core;

public class SecondProcess extends Thread implements Runnable {

	@Override
	public void run() {
		try {
			for (int j = 0; j < 100; j++) {
				Thread.sleep(2000);
				System.out.println("SecondProcess: " + j);
				initLogicStreamExecution();	//..some stream execution
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	 /** некоторое логическое воздействие на объект Alpha*/
	private void initLogicStreamExecution() {
		ModuleAlpha ma = new ModuleAlpha();
		ma.changeObjectState();
		
	}

}
