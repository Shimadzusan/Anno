package workforce;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import util.DataOperation;

public class Farm {
	int agriculture_1 = 1;
	int agriculture_2 = 1;
	int agriculture_3 = 1;
	int product = 0;
	int equipment = 0;
	int workforce = 0;
	
	FarmProcess fp;
	String s = "inneral process";
	
	AccountingDepartment ad = new AccountingDepartment();
	PowerDepartment pd = new PowerDepartment();
	
	List<Worker> worker;//..workforce

	public Farm() {
		
	}
	
	public Farm(List<Worker> worker) {
		this.worker = worker;
	}

	/** метод генерирует значение продукта для одной фермы */
	public void growthAgriculture() throws Exception {
		equipment--;
		Random r = new Random();
		int x = 0;	
		for (int i = 0; i < 2; i++) {
			x = r.nextInt(1000000);
			//produceWork(x + "");
			//System.out.println(x);
			if(x > 10 && compareValue(x))product++;
		}
		System.out.println("..growth ..growth, product: " + product + " equipment: " + equipment);
	}
	
	/** метод имитирует производство некоторой работы, напр. записывает в файл */
//	public void produceWork(String data) throws Exception {
//		String s = new DataOperation().readDataFromFile("C:\\Users\\worker\\eclipse-workspace\\Anno\\farmData.txt");
//		s = s + data;
//		new DataOperation().writeDataToFile("C:\\Users\\worker\\eclipse-workspace\\Anno\\farmData.txt", s);
//		//System.out.println("..produceWork: " + data);
//	}
	
	public void produceWork() throws Exception {
		for (Worker worker_x : worker) {
			worker_x.doWork(this);
		}
//		String s = new DataOperation().readDataFromFile("C:\\Users\\worker\\eclipse-workspace\\Anno\\farmData.txt");
//		s = s + data;
//		new DataOperation().writeDataToFile("C:\\Users\\worker\\eclipse-workspace\\Anno\\farmData.txt", s);
		System.out.println("..produceWork: " + 000);
	}
	
	void calculateBalance() {
		System.out.println("..farm balance ..farm balance");
	}
	
	/** метод вычислияет уникальность значения, если значение уникальное(22, 555...) true, если нет false */
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
