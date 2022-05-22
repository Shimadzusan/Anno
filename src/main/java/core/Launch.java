package core;

import java.io.FileNotFoundException;
import java.io.IOException;

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
//		bn.someMethod();
//		bn.executeTransaction("125", "123", 5);
		
//		String s = new DataOperation().readDataFromFile("C:\\Users\\tokug\\eclipse-workspace\\Anno\\balance.txt");
//		System.out.println(s);
		System.out.println("...end");

	}

}
