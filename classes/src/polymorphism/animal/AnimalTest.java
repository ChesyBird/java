package polymorphism.animal;

public class AnimalTest {

	public static void main(String[] args) {
		
		/*Human human = new Human();
		human.move();
		
		Eagle eagle = new Eagle();
		eagle.move();*/
		
		//다형성을 사용한 자동 타입으로 객체 생성
		//부모 클래스로 객체 생성
		/*Animal human = new Human();
		human.move();*/
		
		//배열로 객체 생성
		Animal[] animals = {
			new Human(),
			new Eagle()
		};
		
		//하나 출력
		animals[0].move();
		animals[1].move();
		System.out.println("===================");
		
		//for(자료형 변수 : 배열) :: 향상된 for문
		for(Animal animal : animals) {
			//animal.move();
			moveAnimal(animal);
		}
	} //main()끝
	
	//다형성 사용 - 매개변수의 다형성
	public static void moveAnimal(Animal animal) {
		animal.move();
	}

}
