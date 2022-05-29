package workforce;

import core.Farm;

public class Worker {
	int id;
	
	/** объект воздействия Farm */
	public void doWork(Farm farm) {
		farm.growthAgriculture();
		System.out.println("worker ..doWork..");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
