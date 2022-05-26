package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
		
		System.out.println("...end");

	}

}
