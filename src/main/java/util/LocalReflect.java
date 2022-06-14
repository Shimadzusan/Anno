package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import core.AccountingDepartment;
import banking.Bank;
import banking.BankingProcess;
import core.Farm;
import core.FarmProcess;
import core.Launch;
import core.MainProcess;
import core.ModuleAlpha;
import core.ModuleBetta;
import core.PowerDepartment;
import core.SecondProcess;
import core.Warehouse;
import core.WarehouseProcess;

public class LocalReflect {
	LocalReflect() throws FileNotFoundException, IOException {
		String[] s = (new DataOperation().readDataFromFile("C:\\Users\\tokug\\eclipse-workspace\\Anno\\listClasses.txt")).split("\n");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i] + " " + s[i].toLowerCase() +  " = new " + s[i] + "();");
		}
		
		AccountingDepartment accountingdepartment = new AccountingDepartment();
		Bank bank = new Bank();
		BankingProcess bankingprocess = new BankingProcess();
		Farm farm = new Farm();
		FarmProcess farmprocess = new FarmProcess();
		Launch launch = new Launch();
		MainProcess mainprocess = new MainProcess();
		ModuleAlpha modulealpha = new ModuleAlpha();
		ModuleBetta modulebetta = new ModuleBetta();
		PowerDepartment powerdepartment = new PowerDepartment();
		SecondProcess secondprocess = new SecondProcess();
		Warehouse warehouse = new Warehouse();
		WarehouseProcess warehouseprocess = new WarehouseProcess();
		DataOperation dataoperation = new DataOperation();
		
		Method[] mtd =	bankingprocess.getClass().getDeclaredMethods();
		for (int i = 0; i < mtd.length; i++) {
			System.out.println(mtd[i]);
		}
		
		System.out.println("======");
		Field[] field = bankingprocess.getClass().getDeclaredFields();
		System.out.println(field.length);
		for (int i = 0; i < field.length; i++) {
			System.out.println(field[i]);
		}
	}

}
