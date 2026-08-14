package ex08.lambda;

/**
 * 함수형 인터페이스
 * - 람다식을 이용해서 사용
 * - 추상메서드가 하나여야 함
 * Greeter
 */
//FunctionalInterface : 인터페이스에 선언된 추상메서드의 갯수를 체크해줌(두개이상이면 오류남)
@FunctionalInterface 
public interface Greeter {

    void greet(String name);
    // void greet1(String name);

}
