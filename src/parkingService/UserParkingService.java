package parkingService;

import passType.PassType;

public interface UserParkingService {
	public void registerCar();
	public void showInfo();
	public void payPrice();
	public PassType choicePassType();
	public void passTypeDetail();
	public void nextDay();
}