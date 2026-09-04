package polymorphism.downcasting;

class Animal{
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Human extends Animal{

	@Override
	public void move() {
		System.out.println("사람이 두발로 걷습니다.");
	}
	
	public void readBook() {
		System.out.println("사람이 책을 읽습니다.");
	}
	
}

class Eagle extends Animal{

	@Override
	public void move() {
		System.out.println("독수리가 하늘을 날아갑니다.");
	}
	
	public void hunting() {
		System.out.println("독수리가 물고기를 사냥합니다.");
	}
	
}

public class AnimalTest {
	//static이 있는 변수: 클래스 변수
	static Animal[] animals = new Animal[2];
	
	public static void main(String[] args) {
		//다형성으로 객체 생성
		animals[0] = new Human();
		animals[1] = new Eagle();
		
		for(Animal animal : animals)
			animal.move();
		
		downCasting();
			
		
		}//main() 끝
	
	
	public static void downCasting() {
		//강제 형변환: instanceof
		for(int i=0; i<animals.length; i++) {
			Animal animal = animals[i];
			if(animal instanceof Human) {
				//작은 자료형 = 큰 자료형
				Human human = (Human)animal;
				human.readBook();
			}else if(animal instanceof Eagle) {
				Eagle eagle = (Eagle)animal;
				eagle.hunting();
			}else {
				System.out.println("지원하지 않는 타입입니다.");
			}
		}

	}//downCasting 끝
}//test끝
