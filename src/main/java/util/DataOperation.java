package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataOperation {
	
	public String readDataFromFile(String fileName) throws FileNotFoundException, IOException {
		String result = "";
		String line;
	        // defaultCharBufferSize = 8192; or 8k
	        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	            
	            while ((line = br.readLine()) != null) {
	               result = result + line + "\n";
	            }
	        }
		return result;
	}
	
	public boolean writeDataToFile(String fileName, String text) {
		return true;
	}

}
