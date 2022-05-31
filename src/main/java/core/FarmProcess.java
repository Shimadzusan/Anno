package core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** здесь описывается только последовательность и логика воздействий, основного процесса*/
public class FarmProcess extends Thread implements Runnable {

	private static final Logger LOG = LogManager.getLogger(FarmProcess.class);
	
	public FarmProcess() throws IOException {

	}

	@Override
	public void run() {
		LOG.info("begin FarmProcess");
		try {
			for (int j = 0; j < ConfigurationModule.quantity; j++) {
				Thread.sleep(ConfigurationModule.frequency);
				initLogicStreamExecution();	//..some stream execution
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LOG.info("end FarmProcess");
	}

	 /** некоторое логическое воздействие на объект Farm*/
	private void initLogicStreamExecution() {
		Farm farm = new Farm();
		farm.growthAgriculture();
		farm.calculateBalance();
		
	}
}
