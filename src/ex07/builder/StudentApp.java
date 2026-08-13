package ex07.builder;

import ex07.builder.StudentDto.Builder;

public class StudentApp {
    public static void main(String[] args) {
        StudentDto.Builder()
            .setStudentId("5001")
            .setName("아이유")
            .setAge(23)
            .setMajor("컴퓨터공학")
            .build(); // 객체생성자를 호출해서 객체를 생성 후 반환

        Builder b = StudentDto.Builder();
        b.setStudentId("5002");
        b.setName("누굴까");
        b.setAge(26);
        b.setMajor("컴퓨터공학");
        StudentDto s = b.build();

        System.out.println(s);
    }
}
