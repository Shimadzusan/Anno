package workforce;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import core.ConfigurationModule;
import workforce.Worker;

/** здесь описывается только последовательность и логика воздействий, основного процесса*/
public class FarmProcess extends Thread implements Runnable {

	private static final Logger LOG = LogManager.getLogger(FarmProcess.class);
	
	// список объектов связанных с процессом
		Farm farm, farm2;
		Worker worker, worker2, worker3;
		List<Worker> workerList = new ArrayList<Worker>(); //..здесь целая группа(список) воркеров
		
		// переменные для управления процессом
		//...
		//...
	
	public FarmProcess() throws IOException {

	}

	@Override
	public void run() {
		LOG.info("begin FarmProcess");
		try {
			initLogicStreamExecution();	//..some stream execution
			for (int j = 0; j < ConfigurationModule.quantity; j++) {
				Thread.sleep(ConfigurationModule.frequency);
				actionLogicStreamExecution();	//..some stream execution

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("end FarmProcess");
	}

	 /** некоторое логическое воздействие на объект Farm*/
	private void initLogicStreamExecution() {
		
		worker = new Worker();
		worker2 = new Worker();
		worker3 = new Worker();
		
		for (int i = 0; i < 200; i++) {
			workerList.add(new Worker());
		}
		
		farm = new Farm(workerList);
		farm2 = new Farm();
	}
	
	 /** некоторое логическое воздействие на объект Farm */
	private void actionLogicStreamExecution() throws Exception {
		farm.calculateBalance();
		farm.produceWork();
		
		worker.doWork(farm);
		worker2.doWork(farm2);
		worker3.doWork(farm2);
//		
//		for (Worker worker : workerList) {
//			worker.doWork(farm);
//		}
		//farm2.growthAgriculture();
		//farm2.calculateBalance();
	}
	
	 /** некоторое логическое воздействие на объект Farm*/
	private void endLogicStreamExecution() {}
	
}
