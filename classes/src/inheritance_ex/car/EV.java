package inheritance_ex.car;

//Car를 상속받은 EV 클래스
public class EV extends Car {
	//필드
	private int battery; //배터리 잔량

	//생성자
	public EV(String brand, String model, int battery) {
		super(brand, model); //부모 필드 상속
		this.battery = battery;
	}
	
	//메서드 재정의(오버라이드)
	@Override
	public void showInfo() {
		super.showInfo(); //부모메서드 상속
		System.out.println("배터리 잔량: " + battery + "%");
	}
	
	//충전 메서드
	public void charge(int amount) {
		//battery = battery + amount
		battery += amount;
		if(battery>100) battery = 100;
		System.out.println(model + "충전됨-배터리: " + battery + "%");
	}
	
}
