package com.kh.inherit.practice;

public class Employee extends Person {
    //필드
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
        super(age, height, weight);
        super.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    //메서드
    public String information(){
        return "";
    }
}
