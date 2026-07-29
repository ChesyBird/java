package ex03.method;

import ex03.method.obj.basic;

/* 
정적 메서드/필드
프로그램이 시작할 때 메모리에 미리 올라가며,
생성하지 않고 사용: 클래스명.메서드명/클래스명.필드명
*/
public class StaticBmiApp {

    // 정적메서드에서는 정적메서드만 호출이 가능
    public static void main(String[] args) {
        // 생성하지 않고 사용할 수 있다
        double bmi = basic.getBmi(1.63, 55);
        String bmiStr = basic.bmiToStr(bmi);
        System.out.println(bmi);
        System.out.println(bmiStr);
    }
       
}
