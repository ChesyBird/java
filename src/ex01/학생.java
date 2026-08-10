package ex01;

public class 학생 {

    //속성
    public String 이름;
    public int 나이;
    // v외부에서 접근이 불가능!
    // 필드에서 직접 초기화
    // 필드를 초기화하지 않는 경우, 타입의 기본값으로 초기화된다
    // 변수는 초기화하지 않고 사용할 수 없다
    private String 학교 = "에듀";


    // 생성자는 보통 필드와 메서드 사이에 위치.
    // 기본생성자: 생성자가 없는 경우 컴파일러가 자동으로 만들어줌
    // ->생성자가 하나라도 있으면 안 만들어줌!
    public 학생() {
        System.out.println("기본 생성자");
    }
    
    // 매개변수가 있는 생성자
    // 객체 초기화
    // 생성자의 특징 - 1. 반환타입 없음 2. 클래스명과 동일

    // 변수명과 필드명이 같은 경우, 변수가 우선이 됨
    // 필드에 접근하기 위해 this 키워드를 사용
    // 매개변수를 이용해서 필드를 초기화
    public 학생(String 이름, int 나이, String 학교) {
        System.out.println("매개변수가 있는 생성자");
        this.이름 = 이름;
        this.나이 = 나이;
        // this.학교 = 학교;
    }




    //메서드
    public void 등교(){

    }

    public void 하교(){

    }

    // Override: 부모메서드 재정의
    // 모든 객체는 object라는 클래스를 상속받는다
    // print함수가 호출될 때 실행
    @Override
    public String toString() {

        // return super.toString(); :기본
        // return 학교 + "/" + 이름 + "/" + 나이;
        return """
                학교 : %s
                이름 : %s
                나이 : %d
                """.formatted(학교, 이름, 나이);
    }

}
