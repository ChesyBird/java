package com.kh.inherit.practice;

public class Student extends Person {
    //필드
    private int grade;
    private String major;

    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }
    public String getMajor() {
        return major;
    }

    //생성자
    public Student(){

    };
    public Student(String name, int age, double height, double weight, int grade, String major){
        super(age, height, weight);
        super.name = name;
        this.grade = grade;
        this.major = major;
    }

    //메서드
    public String information(){
        return "";
    }
}
