package ex08.lambda;

public class App {

    // 접근제한자 생략 - default(패키지 안 사용가능)
    static int operate(int a, int b, Calc calc){
        // 인터페이스의 함수를 호출
        return calc.calc(a, b);
    }

    public static void main(String[] args) {
        /*
        람다식
        함수를 매개변수로 전달하는 간결한 문법
        자바스크립트의 화실표함수와 비슷하다
        */

        // 인터페이스의 구현 클래스를 이용해서 호출
        GreeterImpl greeterImpl = new GreeterImpl();
        greeterImpl.greet("미자");

        // 인터페이스는 생성이 불가능 => 추상메서드이기때문에
        // 추상메서드를 구현하면 생성할 수 있음
        // 익명의 클래스
        Greeter greeter = new Greeter(){

            // 추상메서드 구현
            @Override
            public void greet(String name) {
                System.out.println("익명의 클래스를 이용해서 인터페이스를 구현");
                System.out.println(name + "님 반갑습니다.");
            }

            
        };
        
        greeter.greet("미자");

        // 람다식은 (매개변수)->{실행문} 형태로,
        // 익명 클래스보다 훨씬 간결하게 함수형 인터페이스를 구현하는 문법
        Greeter greeter2 = (String name)->{
            System.out.println(name + "님 환영합니다.");
        };

        greeter2.greet("이름");

        // 매개변수가 하나이면 괄호(타입)생략 가능
        // 매개변수의 타입도 생략가능(추상메서드가 하나이기 때문에 추론이 가능!)
        // 실행문이 한줄이면 코드블럭 생략 가능(반환도 생략 가능)
        Greeter greeter3 = name-> System.out.println(name + "님 감사합니다.");

        greeter3.greet("이름");

        System.out.println("=================================================");

        // 람다식을 매개변수로 전달해서 호출
        // 1. 인터페이스 - 추상메서드가 하나. Calc.calc(int a, int b)
        // 2. 인터페이스를 매개변수로 받아서 실행하는 메서드 만들기
        // 3. 람다식을 이용해서 매개변수에 함수(메서드)를 전달
        int res = operate(2, 3, (a,b)->{return a+b;});
        int res2 = operate(7, 6, (a,b)->a*b);

        System.out.println("2 + 3 = " + res);
        System.out.println("7 * 6 = " + res2);

    }
}

// 하나의 파일에 여러개의 클래스/인터페이스를 정의하는 경우 
// public은 파일 이름과 같은 곳 하나에만 사용 가능
interface Calc {
    int calc(int a, int b);
}
