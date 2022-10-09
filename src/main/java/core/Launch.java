package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import banking.Bank;
import banking.BankingProcess;
import util.DataOperation;
import workforce.FarmProcess;

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
		//mp.start();
		
		Thread sp = new SecondProcess();
		//sp.start();
		
		Thread fp = new FarmProcess();
		fp.start();
		
		Thread bk = new BankingProcess();
		//bk.start();
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
