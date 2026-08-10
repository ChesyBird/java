// 클래스 선언부
// 코드블록{}
// 접근제한자 class 클래스명 {}
/*
    누구나 접근가능: public
    일부만 접근하도록 제한: privit
    그밖에도 위치에 따른 접근제한자 종류가 있음.
    총 네가지.
*/

import java.util.Scanner;

public class MyApp {

    // 속성 = 필드
    // 타입 변수명 = 값

    // 기능 = 메서드
    // 메서드 선언부
    // 접근제한자 반환타입 메서드이름(매개변수타입 매개변수이름){코드블럭}
    // void: 반환타입이 없으면 적어주는 키워드

    public static void main(String[] args) {

        // 변수 선언
        // 변수타입 변수명 = 값(리터럴);
        // int(정수), double, String(문자열) ...
        String name = "minhye";
        int age = 29;


        System.out.println(name);
        System.out.println(age);

        // a, b 변수를 선언하고 두 변수의 합을 출력해보자.
        int a = 2, b = 4; //같은 타입은 ,를 이용해서 합치기 ㄱㄴ
        int res = a + b;
        System.out.print("두 수의 합 : "); // 줄바꿈 없이 출력
        System.out.println(res); // 출력 후 줄바꿈

        // 하나의 문자를 작은 따옴표로 감싼 것
        char var = 'A';
        char var1 = 65;

        // + 연산자는 문자열을 연결하는 역할도 함!
        System.out.println("var : " + var);
        System.out.println("var1 : " + var1);

        // int 타입의 허용 범위를 넘어서는 경우
        // 리터럴이 들어오면 기본형으로 변경
        // 정수: int형, 실수: flot형
        // long(Ll), float(Ff)같은 경우 타입 선언 후 리터럴 뒤에 타입을 붙여줘야함 
        //long num = 2200000000l;
        double num2 = 1.2;
        float num3 = 1.2f; 

        // 변수명을 작성할 때
        // 이미 선언된 변수명은 사용불가
        // 예약어(키워드) 사용불가
        // 숫자시작 불가
        // 소문자 작성이 관례.(단, 상수는 모두 대문자)
        // _, $ 사용가능
        // 여러개의 단어가 합쳐지는 경우 카멜표기법
        //boolean trueVar = true;
        boolean result = num2 > num3;

        if(!result){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        // 이스케이프 문자
        // 정해진 역할이 있는 문자들
        // ex: ", ', \
        System.out.println("\"");
        System.out.println("\"오늘도 수고가 많으십니다.\"");

        // 자동형변환이 가능한 경우
        // 값의 허용범위가 작은 타입이 큰 타입으로 대입될 때.
        byte n = 127; //-128 ~ 127
        // n++, ++n
        System.out.println("127++ : " + ++n);
        System.out.println(n);
        //int i = n;

        // 강제 형변환 - 값이 왜곡될 수 있음(비추!)
        System.out.println((byte)1000);

        try (// 입력을 받기 위해 사용하는 객체
                // 변수타입 : 객체는 타입으로 사용할 수 있다
                // 입력받기 위해서 입력을 받을 수 있는 스캐너 객체를 생성 
        Scanner scanner = new Scanner(System.in)) {
            // 콘솔창에서 입력을 대기하고 있다가 
            // 엔터키가 눌러지면 사용자의 입력을 받아서 변환
            String str = scanner.next();
            System.out.println("사용자의 입력값 : " + str);
        } 

        // 출력 - 형식에 맞게 출력

    }
}
