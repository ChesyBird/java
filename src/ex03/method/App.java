package ex03.method;

import ex03.method.obj.*;

public class App {
    public static void main(String[] args) {
        // 패키지가 다른 경우  import문을 작성 -> ctrl + space 자동완성
        // Basic 객체 생성하기
        basic basic = new basic();
        
        // + info(name:String, age:int, height:double):void
        basic.info("김민혜", 29, 158.5);
        
        // + getInfo(name:String, age:int, height:double):String
        // 이름 나이 키를 받아서 출력/반환
        String basic_info = basic.getInfo("김민재", 27, 170.0);
        // 반환받은 값을 변수에 저장하여 출력
        System.out.println(basic_info);

        // + getBmi(키-m:double, 몸무게-kg:double): double
        // 메서드를 호출할 때는 파라메터(값)만 넘겨준다
        double bmi = ex03.method.obj.basic.getBmi(1.63, 55.5);
        String str = ex03.method.obj.basic.bmiToStr(bmi);
        System.out.println(str);
    }
}
