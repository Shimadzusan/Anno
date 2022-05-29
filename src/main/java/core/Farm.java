package core;

import java.util.Random;

public class Farm {
	
	int agriculture_1 = 1;
	int agriculture_2 = 1;
	int agriculture_3 = 1;
	int product = 0;
	int equipment = 0;
	int forkforce = 0;
	
	FarmProcess fp;
	String s = "inneral process";
	
	AccountingDepartment ad = new AccountingDepartment();
	PowerDepartment pd = new PowerDepartment();

	/** метод генерирует значение продукта для одной фермы */
	public void growthAgriculture() {
		equipment++;
		Random r = new Random();
		int x = 0;	
		for (int i = 0; i < 2; i++) {
			x = r.nextInt(1000000);
			//System.out.println(x);
			if(x > 10 && compareValue(x))product++;
		}
		System.out.println("..growth ..growth, product: " + product + " equipment: " + equipment);
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

