package parkingCarRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import passType.PassType;

@RequiredArgsConstructor
@Data
public class CarData {
	private final String carNumber;
	private final String model;
	private final PassType passType; // 요금제
	private int days;
}