package inheritance_ex.student;

public class Person {
	//필드(변수, 속성)
	protected String name;
	
	//생성자(Constructor)
	public Person(String name) {
		this.name = name;
	}
	
	//메서드(함수)
	public void introduce() {
		System.out.println("안녕하세요, " + name + "입니다.");
	}
	
}
