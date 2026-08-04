package com.kh.practice2.model.vo;

//abstract: 추상 클래스
//자식을 통해서만 생성이 가능- 타입으로 사용
//핵심적인 공통 기능만 추출하여 단순화
//중복 제거: 재사용 - 수정이 발생할 경우 한 곳만 수정하면 됨
public abstract class Animal {

    //필드
    private String name;
    private String kinds;

    //생성자
    protected Animal(){

    };
    //생성자의 오버로딩
    protected Animal(String name, String kind){
        //필드를 초기화
        this.name = name;
        //필드명이 다르면 this 없어도 ㅇㅋ
        kinds = kind;
    };

    //메서드
    //@:어노테이션
    //Override: 부모 메서드를 자식이 재정의
    //print문에 객체를 넣으면 toString메서드의 결과가 출력됨
    @Override
    public String toString() {
        String str = "저의 이름은 %s이고, 종류는 %s입니다.".formatted(name, kinds);
        return str;
    }

    //추상메서드: 코드블럭 없음
    //자식에게 기능 구현을 위임
    public abstract void speak();

}
