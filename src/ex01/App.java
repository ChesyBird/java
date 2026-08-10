package ex01;

public class App {
    public static void main(String[] args) {
        // 학생객체를 생성
        // 타입 변수명 = new 타입();
        // 
        학생 학생1 = new 학생();

        // 필드를 초기화
        학생1.이름 = "김록수";
        학생1.나이 = 20;
        
        학생 학생2 = new 학생();

        학생2.이름 = "이수혁";
        학생2.나이 = 23;

        // 매개변수가 있는 생성자를 이용하기
        // 매개변수 명 없이 써주면 ㅇㅋ!
        //학생 학생3 = new 학생("최정수", 20, "스카이에듀");
        학생 학생4 = new 학생("최한", 25, "스카이에듀");

        // 객체를 print메서드를 이용해서 출력하면 toString()메서드가 호출됨
        // toString()메서드는 패키지를 포함한 클래스 이름@메모리주소
        // -> 메서드 Override를 통해서 재정의 할 수 있다
        System.out.println(학생1);
        System.out.println(학생4);
    }
}
