package parkingSystemMain;

import java.util.Scanner;

import parkingCarRepository.AllCarsRepository;
import parkingService.ParkingService;
import parkingService.UserParkingService;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AllCarsRepository allCarsRepository = AllCarsRepository.getInstance();
		UserParkingService parkingService = new ParkingService(sc, allCarsRepository, allCarsRepository.getArrCarData());
		
		
		while(true) {
			System.out.println("어서오세요.");
			System.out.println("[메뉴 선택]");
			System.out.println("1. 차량 등록\n2. 차량 나가기 및 요금 결제\n3. 전체 차량 정보보기\n4. 다음 날\n5. 프로그램 종료");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 1) {
				parkingService.registerCar();
			}else if(choice == 2) {
				parkingService.payPrice();
			}else if(choice == 3) {
				parkingService.showInfo();
			}else if(choice == 4) {
				parkingService.nextDay();
			}else if(choice == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("?");
			}
		}
	}
}