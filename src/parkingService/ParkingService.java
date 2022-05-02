package parkingService;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import parkingCarRepository.AllCarsRepository;
import parkingCarRepository.CarData;
import passType.DayPass;
import passType.PassType;
import passType.TimePass;
import passType.WeekPass;

@RequiredArgsConstructor
public class ParkingService implements UserParkingService{
	private final Scanner sc;
	@NonNull
	AllCarsRepository carRepository;
	@NonNull
	ArrayList<CarData> allCarsRepository;

	@Override
	public void registerCar() {
		System.out.println("차량을 등록합니다.");
		System.out.print("차량번호 입력: ");
		String carNumber = sc.nextLine();
		System.out.print("차량모델 입력: ");
		String model = sc.nextLine();
		System.out.print("요금제 선택: ");
		PassType payType = choicePassType();
		CarData carData = new CarData(carNumber, model, payType);
		allCarsRepository.add(carData);
		System.out.println("차량번호: " + carNumber + " 가 정상 등록되었습니다.");
		
	}

	@Override
	public void showInfo() {
		if(allCarsRepository.size() == 0) {
			System.out.println("아직 등록된 차량이 없습니다.");
			return;
		}
		for(int i = 0; i < allCarsRepository.size(); i++) {
			System.out.println((i + 1) +". " + allCarsRepository.get(i));
		}
	}

	@Override
	public void payPrice() {
		if(allCarsRepository.size() == 0) {
			System.out.println("아직 등록된 차량이 없습니다.");
			return;
		}
		int price = 0;
		System.out.print("차량번호 입력: ");
		String carNumber = sc.nextLine();
		boolean noCar = true;
		for(CarData carData : allCarsRepository) {
			if(carData.getCarNumber().equals(carNumber)) {
				PassType passType = carData.getPassType();
				if(passType instanceof TimePass) {
					price = carData.getDays() * 24000;
				}else if(passType instanceof DayPass) {
					if(carData.getDays() < 2)
						price = 0;
					else
						price = (carData.getDays() - 1) * 24000;
				}else if(passType instanceof WeekPass) {
					if(carData.getDays() < 8)
						price = 0;
					else
						price = (carData.getDays() - 7) * 24000;
				}
				allCarsRepository.remove(carData);
				System.out.println("요금: " + price + "원");
				noCar = false;
				break;
			}
		}
		if(noCar == true) {
			System.out.println("해당 차량번호는 존재하지 않습니다.");
		}
	}

	@Override
	public PassType choicePassType() {
		PassType passType = null;
		while(true) {
			System.out.println("[요금제]");
			System.out.println("1. 시간제\n2. 1일 이용권\n3. 일주일 이용권\n4. 요금제 상세보기");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) {
				passType = new TimePass();
			}else if(choice == 2) {
				passType = new DayPass();
			}else if(choice == 3) {
				passType = new WeekPass();
			}else if(choice == 4) {
				passTypeDetail();
			}else {
				System.out.println("??");
			}
			if(passType != null)
				break;
		}
		
		return passType;
	}
	
	@Override
	public void passTypeDetail() {
		System.out.println("시간제: 1시간당 천원 부과");
		System.out.println("1일 이용권: 2만원(하루 초과시 시간당 천원 부과)");
		System.out.println("일주일 이용권: 10만원(하루 초과시 시간당 천원 부과)");
	}

	@Override
	public void nextDay() {
		if(allCarsRepository.size() == 0)
			return;
		for(CarData carData : allCarsRepository) {
			carData.setDays(carData.getDays() + 1);
		}
	}
}