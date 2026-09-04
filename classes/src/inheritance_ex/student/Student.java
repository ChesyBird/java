package inheritance_ex.student;

public class Student extends Person {
	//필드(멤버변수)
	private String school;
	
	//생성자
	public Student(String name, String school) {
		super(name); //부모클래스의 멤버변수
		this.school = school;
	}
	
	//메서드
	@Override
	public void introduce() {
		super.introduce(); //부모클래스의 메서드
		System.out.println(school + " 학생입니다.");
	}
	
}