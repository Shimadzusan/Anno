package core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


public class ConfigurationModule {
	static {
		Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("configuration.properties"))){
            props.load(in);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        frequency = Integer.parseInt(props.getProperty("frequency"));
        quantity = Integer.parseInt(props.getProperty("quantity"));
       // System.out.println(frequency + " / " + quantity);
	}
	
	public static int frequency;
	public static int quantity;
	


}
