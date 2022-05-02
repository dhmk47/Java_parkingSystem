package parkingCarRepository;

import java.util.ArrayList;

import lombok.Getter;

@Getter
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
}