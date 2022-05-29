package core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/** здесь описывается только последовательность и логика воздействий, основного процесса*/
public class FarmProcess extends Thread implements Runnable {
	int frequency;
	int quantity;
	public FarmProcess() throws IOException {
		Properties props = new Properties();
	        try(InputStream in = Files.newInputStream(Paths.get("configuration.properties"))){
	            props.load(in);
	        }
	        frequency = Integer.parseInt(props.getProperty("frequency"));
	        quantity = Integer.parseInt(props.getProperty("quantity"));
//	        String username = props.getProperty("username");
//	        String password = props.getProperty("password");
	        System.out.println(frequency + " / " + quantity);
	}

	@Override
	public void run() {
		try {
			for (int j = 0; j < quantity; j++) {
				Thread.sleep(frequency);
				initLogicStreamExecution();	//..some stream execution
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	 /** некоторое логическое воздействие на объект Farm*/
	private void initLogicStreamExecution() {
		Farm farm = new Farm();
		farm.growthAgriculture();
		farm.calculateBalance();
		
	}
}
