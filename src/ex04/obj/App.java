package ex04.obj;

public class App {
    public static void main(String[] args) {
        Student s1 = new Student("김민혜","19961007");
        Student s2 = new Student("김민혜","19961007");

        if (s1.equals(s2)) {
            System.out.println("같은 객체입니다.");
        } else {
            System.out.println("다른 객체입니다.");
        }

        // String 객체의 equals 메서드도 재정의 되어있다
        //같은 문자열이면 같다고 판단
        // "".equals(s2);
    }
}
