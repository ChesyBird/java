package com.kh.object.practice;

public class StaticSample {

    // 필드
    // 외부에 노출되지 않는다 = 외부에서 접근할 수 없다.
    // 일반, 고속 두가지 값만
    private String value;

    // 생성자: 만들지 않으면 컴파일러에서 기본생성자

    // 생성자/메서드의 오버로딩: 메서드의 이름은 같은데
    // -> 매개변수의 갯수나 타입이 다른 경우
    // 메서드/생성자의 선언부는 중복될 수 없다
    public StaticSample(){
        value = "";
    }

    public StaticSample(String value){
        // 필드명과 매개변수명이 같은 경우 this. 키워드가 있어야 필드접근 가능
        this.value = value;
    }
    

    // 메서드

    // setter, getter메서드
    // 필드의 접근제한자가 private인 경우
    // setter, better메서드를 통해 필드의 값을 변경하거나 가지고 갈 수 있도록 한다

    /**
     * StaticSample의 value속성을 매개변수로 받아온 값으로 설정한다
     * @param value
     */
    public void setValue(String value) {
        // 외부에서 입력한 값이 변경가능한 값인지 체크
        if(value.equals("일반")||value.equals("고속")){
            this.value = value;
        }
    }

    /**
     * StaticSample의 value속성의 값을 반환한다
     * @return
     */
    public String getValue() {
        return value;
    }

    public void toUpper(){

    }

    public void setChar(int index, char c){

    }

    public int valueLength(){
        return 0;
    }

    public String valueConcat(String str){
        return str;
    }

    // 메서드 재정의 - 부모가 가진 메서드를 자식이 다시 정의하는 것
    // 메서드의 선언부는 바뀌지 않는다
    @Override //어노테이션
    public String toString() {
        return "등급 : " + value;
    }

}
