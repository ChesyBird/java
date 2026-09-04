package exam;

import java.util.ArrayList;

public class StudentMain {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("홍길동", 90));
        students.add(new Student("김철수", 87));
        students.add(new Student("이영희", 95));

        for(Student s : students){
            System.out.println(s.toString());
        }
    }
}
