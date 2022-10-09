package workforce;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import logistic.Warehouse;
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
	Warehouse warehouse;

	public Farm(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	public Farm(List<Worker> worker, Warehouse warehouse) {
		this.worker = worker;
		this.warehouse = warehouse;
	}

	/** метод генерирует значение продукта для одной фермы, главное уравнение системы a+b=c */
	public void growthAgriculture(Worker worker) throws Exception {
		equipment--;
		Random r = new Random();
		int x = 0;	
		for (int i = 0; i < worker.getExperience(); i++) {
			x = r.nextInt(1_000_000);
			if(x > 10 && compareValue(x)) {
				product++;
				worker.setExperience(worker.getExperience() + 1);
				calculateBalance();
				System.out.println(x);
			}
			
		}
		//System.out.println("..growth ..growth, product: " + product + " equipment: " + equipment);
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
		//System.out.println("..produceWork: " + 000);
	}
	
	void calculateBalance() throws IOException {
		//System.out.println("..farm balance ..farm balance");
		if(product >= 2) {
			System.out.println("product: " + product);
		warehouse.setWare(warehouse.getWare() + product);
		product = 0;
		}
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
