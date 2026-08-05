package com.kh.inherit;

import com.kh.inherit.practice.Employee;
import com.kh.inherit.practice.Student;
import com.kh.util.inputUtil;

public class App {
    public static void main(String[] args) {
        //학생 3명 기록하는 객체배열
        Student[] students = new Student[3];

        //학생 객체 생성
        students[0] = 
            new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        students[1] = 
            new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        students[2] = 
            new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

        //반복문으로 출력
        for(Student s : students){
            // toString() 실행결과 반환받은 문자열을 출력
            System.out.println(s);
            // s.information();
        }

        //사원 10명 객체배열
        Employee[] emps = new Employee[10];
        emps[0] = 
            new Employee("박보검", 28, 180.3, 72.0, 100000000, "영업부");

            // emps[1] = 
            //     new Employee(name, age, height, weight, salary, dept);
            
            // System.out.println(emps[1]);
            
        int index = 0;

            //반복해서 받은 사용자 입력값으로 객체 생성
            //계속할건지 물어보기
        while (true) {
        //키보드로부터 사원정보를 입력받아 배열에 저장
        //사용자의 입력값을 변수로 저장했다가 객체를 만들 때 사용
        String name = inputUtil.getString("이름: ");
        int age = inputUtil.getInt("나이: ");
        double height = inputUtil.getDouble("키: ");
        double weight = inputUtil.getDouble("몸무게: ");
        int salary = inputUtil.getInt("급여: ");
        String dept = inputUtil.getString("부서: ");
        
        emps[index] =
            new Employee(name, age, height, weight, salary, dept);
        
        String res = inputUtil.getString("계속 입력하시겠습니까?(Y/N)");
        if(!res.equalsIgnoreCase("Y")){
            //Y가 아니면 반복문 탈출
            break;
        }
        index++;
        }

        
    }
}
