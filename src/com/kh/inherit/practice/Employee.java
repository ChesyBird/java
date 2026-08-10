package com.kh.inherit.practice;

import ex06.annotation.Required;

public class Employee extends Person {
    //필드
    @Required
    private int salary;
    private String dept;

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }
    public String getDept() {
        return dept;
    }

    //생성자
    public Employee(){

    };
    public Employee(String name, int age, double height, double weight, int salary, String dept){
        //부모의 생성자를 호출 - 항상 맨 위에!
        super(age, height, weight);
        //super.name = name;
        setName(name); //권장: 생성자를 이용한 초기화!
        this.salary = salary;
        this.dept = dept;
    }

    //메서드
    @Override
    public String information() {
        return "";
    }

    @Override
    public String toString() {
        return super.toString() + """
                급여: %d
                부서: %s
                """.formatted(salary, dept);
    }
}
