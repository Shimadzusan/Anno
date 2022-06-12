package core;

import java.util.ArrayList;
import java.util.List;

import workforce.Worker;

/** здесь описывается только последовательность и логика воздействий, основного процесса*/
public class FarmProcess extends Thread implements Runnable {
	// список объектов связанных с процессом
	Farm farm, farm2;
	Worker worker, worker2, worker3;
	List<Worker> workerList = new ArrayList<Worker>();
	
	// переменные для управления процессом
	//...
	//...
	
	@Override
	public void run() {
		try {
			initLogicStreamExecution();	//..some stream execution
			for (int j = 0; j < 100; j++) {
				Thread.sleep(2500);
				actionLogicStreamExecution();	//..some stream execution
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	 /** некоторое логическое воздействие на объект Farm*/
	private void initLogicStreamExecution() {
		farm = new Farm();
		farm2 = new Farm();
		
		worker = new Worker();
		worker2 = new Worker();
		worker3 = new Worker();
		
		for (int i = 0; i < 200; i++) {
			workerList.add(new Worker());
		}
	}
	
	 /** некоторое логическое воздействие на объект Farm */
	private void actionLogicStreamExecution() throws Exception {
		//farm.growthAgriculture();
		farm.calculateBalance();
		worker.doWork(farm);
		worker2.doWork(farm2);
		worker3.doWork(farm2);
		
		for (Worker worker : workerList) {
			worker.doWork(farm);
		}
		//farm2.growthAgriculture();
		farm2.calculateBalance();
	}
	
	 /** некоторое логическое воздействие на объект Farm*/
	private void endLogicStreamExecution() {}
	
}
