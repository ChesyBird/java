package inheritance_ex.test;

import inheritance_ex.animal.Cat;
import inheritance_ex.animal.Dog;

public class AnimalTest {

	public static void main(String[] args) {
		
		//Dog 객체 생성
		Dog dog1 = new Dog();
		Cat cat1 = new Cat();
		
		dog1.eat();
		dog1.bark();
		System.out.println("===========");
		cat1.eat();
		cat1.cry();
		
	}

}
