package com.kh.inherit.practice;

//모든 객체는 Object를 상속받는다
public class Person {
    //필드
    protected String name;
    private int age;
    private double height;
    private double weight;

    public void setAge(int age) {
        this.age = age;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }
    public double getHeight() {
        return height;
    }
    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }

    //생성자
    public Person(){

    };
    public Person(int age, double height, double weight){
        this.age = age;
        this.height = height;
        this.weight = weight;
    };

    //메서드
    public String information(){
        return "";
    };

    @Override
    public String toString() {
        return """
                이름: %s
                나이: %d
                키: %f
                몸무게: %f
                """.formatted(name, age, height, weight);
    }

}
