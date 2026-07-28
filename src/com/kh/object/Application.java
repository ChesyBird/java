package com.kh.object;

import com.kh.object.practice.StaticSample;

public class Application {
    public static void main(String[] args) {
        // 타입 변수명 = new 타입
        // 생성자를 호출하여 객체를 생성합니다
        StaticSample ss = new StaticSample();
        
        // 변수명에 . 찍어서 객체가 가지고 있는 필드, 메서드에 접근
        ss.setValue("일반");

        System.out.println("등급 : " + ss.getValue());
        
        // toString() : 기본-패키지를 포함한 클래스명@16진수주소
        System.out.println(ss.toString());
        System.out.println(ss);
    }
}
