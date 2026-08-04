package com.kh.practice2.model.vo;

//vo,dto: 필드와 setter, getter 메서드를 가진
//데이터를 담는 그릇과 같은 역할

//자식은 부모가 가진 모든 필드와 메서드를 상속
//미구현된 메서드가 있다면 구현하거나 추상클래스가 되어야함
public class Dog extends Animal {

    //필드
    public static final String PLACE = "애견카페";
    private int weight;

    //생성자
    //접근제한자를 안 쓸 경우 default 접근제한자가 됨
    //같은 패키지에서만 접근 가능
    public Dog(){

    };

    public Dog(String name, String kinds, int weight){
        //부모의 생성자를 호출해서 초기화
        super(name, kinds);
        this.weight = weight;
    }

    //메서드
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static String getPlace() {
        return PLACE;
    }

    public int getWeight() {
        return weight;
    };

    @Override
    public void speak() {
        System.out.println(super.toString());
        System.out.println("몸무게는 %skg 입니다.".formatted(weight));
        //예외를 발생시켜 호출한 곳으로 던진다
        //throw new UnsupportedOperationException
    };


}
