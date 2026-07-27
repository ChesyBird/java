// 패키지 선언부:: 나의 위치
package com.kh.object.practice;

// 클래스 선언부
public class NonStaticSample {
    // 생성자

    // 필드

    // 메서드
    // 접근제한자:생략가능 반환타입 메서드명(매개변수타입 변수이름){}
    public void printLottoNumbers(){
        // 자바 표준 출력
        // 콘솔창에 출력할 때 사용
        System.out.print("printLottoNumbers()가 호출되었습니다."); //줄바꿈 없이 출력
        System.out.println("로또번호를 생성합니다."); //출력 후 줄바꿈
        System.out.printf(""); //형식을 이용한 출력
    }

    public void outputChar(int num, char c){
        // return "": 문자열
        // return '': 하나의 문자
        // return 0
    }

    // 반환타입을 적고 return을 안 하면 오류가 발생
    public char alphabette(){
        // 반환타입에 해당하는 것
        return 'a';
    }

    public String mySubstring(String str, int index1, int index2){
        return "";
    }

}
