package core;

public class Farm {
	
	int agriculture_1 = 1;
	int agriculture_2 = 1;
	int agriculture_3 = 1;
	AccountingDepartment ad = new AccountingDepartment();
	PowerDepartment pd = new PowerDepartment();

	void growthAgriculture() {
		System.out.println("..growth ..growth");
	}
	
	void calculateBalance() {
		System.out.println("..farm balance ..farm balance");
	}
	
}

