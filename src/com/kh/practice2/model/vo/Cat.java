package com.kh.practice2.model.vo;

public class Cat extends Animal {

    //필드(전역변수)
    //필드를 초기화하지 않으면 타입의 기본값으로 초기화된다
    private String location;
    private String color;

    //생성자
    public Cat(){
        //String a = "지역변수" : 초기화하지 않으면 사용할 수 없다
    };

    public Cat(String name, String kinds, String location, String color){
        super(name, kinds);
        this.location = location;
        this.color = color;
    };

    //메서드
    public void setColor(String color) {
        this.color = color;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getColor() {
        return color;
    }

    public String getLocation() {
        return location;
    }

    //부모의 추상메서드(코드블럭 없음)를 구현해야함
    @Override
    public void speak() {
       System.out.println(super.toString());
       System.out.println("%s에 서식하며, 색상은 %s입니다.".formatted(location, color) );
    }


}
