package core;

public class MainProcess extends Thread implements Runnable {

	@Override
	public void run() {
		try {
			for (int j = 0; j < 150; j++) {
				Thread.sleep(5000);
				System.out.println("MainProcess: " + j);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

}
