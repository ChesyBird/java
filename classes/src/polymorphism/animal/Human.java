package polymorphism.animal;

public class Human extends Animal {

	//메서드 재정의
	//우클릭 - source -override/implement
	@Override
	public void move() {
		System.out.println("사람이 두발로 걷습니다.");
	}
	
}
