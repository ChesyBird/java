package ex02;

public class App {
    public static void main(String[] args) {
        // 타입 변수명
        학과 학과1 = new 학과("", "컴퓨터공학", 25);
        학과 학과2 = new 학과("D002", "멀티미디어디자인", 20);
        학과 학과3 = new 학과("D003", "일본어");
        학과 학과4 = new 학과("D004", 15);
        // new를 만나서 생성자가 실행이 된다

        System.out.println(학과1);
        System.out.println(학과2);
        System.out.println(학과3);
        System.out.println(학과4);
    }
    
    
}
