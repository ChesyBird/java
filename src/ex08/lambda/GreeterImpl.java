package ex08.lambda;

// implements : 인터페이스를 구현
public class GreeterImpl implements Greeter {

    @Override
    public void greet(String name) {
        System.out.println(name + "님 환영합니다.");   

    }

}
