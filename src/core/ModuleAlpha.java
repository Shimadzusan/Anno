package core;

import java.util.Random;

public class ModuleAlpha {
	int x = 10;
	int y = 200;
	int z = 370;
	
	/** просто возвразает сумму значений которая не может быть больше 60*/
	public int getObjectValue() {
		return x + y + z;
	}
	
	public boolean changeObjectState() {
		Random randomNumber = new Random();
		x = randomNumber.nextInt(10);
		y = randomNumber.nextInt(20);
		z = randomNumber.nextInt(30);
		
		System.out.println("result: " + x + " " +  y + " " + z);
		
		return true;
	}

}
