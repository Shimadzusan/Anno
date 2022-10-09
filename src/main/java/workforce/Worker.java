package workforce;


public class Worker {
	int id;
	int experience = 10;
	
	
	/** объект воздействия Farm */
	public void doWork(Farm farm) throws Exception {
		farm.growthAgriculture(this);
		//System.out.println("worker ..doWork.. experience: " + experience);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
