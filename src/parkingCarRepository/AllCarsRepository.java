package parkingCarRepository;

import java.util.ArrayList;

public class AllCarsRepository {
	private static AllCarsRepository instance;
	private ArrayList<CarData> arrCarData;
	
	private AllCarsRepository() {
		arrCarData = new ArrayList<CarData>();
	}
	
	public static AllCarsRepository getInstance() {
		if(instance == null) {
			instance = new AllCarsRepository();
		}
		return instance;
	}

	public ArrayList<CarData> getArrCarData() {
		return arrCarData;
	}

	public void setArrCarData(CarData carData) {
		this.arrCarData.add(carData);
	}
}