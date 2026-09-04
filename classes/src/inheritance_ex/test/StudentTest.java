package inheritance_ex.test;

import inheritance_ex.student.Student;

public class StudentTest {

	public static void main(String[] args) {
		//Student의 객체 생성
		Student st1 = new Student("장그래", "한강대학교");
		st1.introduce();

	}

}
