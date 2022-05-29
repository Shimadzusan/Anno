package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Date;
import java.util.Random;

import util.DataOperation;

/**
 * Основной поток исполнения, и остальные дополнительные итд
 * Классы, объекты, переменные, методы
 * Импорты, др. информация
 * Модульность, подключение/отключение
 * */
public class Launch {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("..begin point of the stream execution");
		System.out.println("..something execution");
		System.out.println("..end point of the stream execution");

// создаем все необходимые для работы объекты и процессы
		Thread mp = new MainProcess();
		mp.start();
		
		Thread sp = new SecondProcess();
		sp.start();
		
		Thread fp = new FarmProcess();
		fp.start();
		
		Thread bk = new BankingProcess();
		bk.start();
		
//===========================================
//		Bank bn = new Bank();
//		bn.uploadData();
//		Random randomNumber = new Random();
//		int x = randomNumber.nextInt(1001, 1200);
//		int y = randomNumber.nextInt(1001, 1200);
//		int z = randomNumber.nextInt(100);
//		bn.executeTransaction(x + "", y + "", z);
//		System.out.println("+-+");
//		bn.downloadData();
		//new DataOperation().writeDataToFile("C:\\Users\\tokug\\eclipse-workspace\\Anno\\balance.txt", "125+125+125");
		
//*************************************************************
//		Random r = new Random();
//		
//		int x = 0;
//		long a = System.currentTimeMillis();
//		long b;
//		int z = 0;
//		
//		for (int i = 0; i < 1_000_000; i++) {
//			x = r.nextInt(1000000);
//			//System.out.println(i);
//			
//			//if(x > 10 && compareValue(x))System.out.println("+" + x);
//			if(x > 10 && compareValue(x))z++;
//			 
//		}
//		System.out.println("z: " + z);
//		//System.out.println(compareValue(447));
//		b = System.currentTimeMillis();
//		System.out.println(b-a);
//
//		System.out.println("...end");

	}

	/** description... */
	private static boolean compareValue(int number) {
		char[] chArray = (number + "").toCharArray();
		int flag = 0;
		for (int i = 0; i < chArray.length; i++) {
			if(chArray[0] == chArray[i])flag++;
		}
		if(chArray.length == flag)return true;
		else return false;
		
	}

}
