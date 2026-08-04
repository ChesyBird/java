package com.kh.inherit;

import com.kh.inherit.practice.Employee;
import com.kh.inherit.practice.Student;

public class App {
    public static void main(String[] args) {
        //학생 3명 기록하는 객체배열
        Student[] students = new Student[3];

        //학생 객체 생성
        students[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        students[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        students[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

        //반복문으로 출력
        for(Student a : students){
            a.information();
        }

        //사원 10명 객체배열
        Employee[] employees = new Employee[10];

        

    }
}
