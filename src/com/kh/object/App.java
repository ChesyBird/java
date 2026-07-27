// 패키지
// 클래스의 일부이며 클래스를 식별하는 용도
// 상위 패키지, 하위 패키지로 구분하며 구분자는 '.'
// 패키지 선언은 최상단에 위치하며 없거나 잘못 작성된 경우 오류
package com.kh.object;

// 다른 패키지에 있는 클래스를 사용할 경우 필요함
// import문은 패키지의 선언과 클래스의 선언 사이에 작성
// 자동완성 시 import문도 자동으로 완성되지만 코드를 수기작성하는 경우 안나오기도 함
// -> 이 경우 오류가 난 클래스에 커서를 두고 alt + shift + o
import com.kh.object.practice.NonStaticSample;

// 클래스의 선언부
public class App {

    // 프로그램의 시작
    // 없으면 실행이 안됨:)
    public static void main(String[] args) {
        // 1. 객체 생성: 클래스(설계도)를 통해서 객체를 생성
        // 타입 변수명 = new연산자 타입();
        // new연산자를 통해 생성자를 실행하여 객체를 생성하고 변수에 담아준다
        // 클래스 -> 인스턴스(메모리에 올라가서 사용가능 상태)
        NonStaticSample sample = new NonStaticSample();

        // 변수명에 .을 찍으면 객체가 가지고 있는 속성, 메서드에 접근 가능
        // 파일 이름을 이용해서 리소스 찾기: ctrl + p
        sample.printLottoNumbers();

    }
}
