package inheritance_ex.test;

import inheritance_ex.car.Car;
import inheritance_ex.car.EV;

public class CarTest {

	//CarTest.main() 
	//진입점(new를 사용하지 않기 위해 static사용
	public static void main(String[] args) {
		
		Car car1 = new Car("현대자동차", "Sonata");
		
		car1.showInfo();

		//EV객체 생성
		EV ev1 = new EV("기아자동차", "EV6", 60);
		
		ev1.showInfo();
		
		ev1.charge(70);
		
		ev1.accelerate(70);
		ev1.brake(20);
		
	}
}
