package ex09.file;

public class SwitchEx {
    public static void main(String[] args) {
        // 조건문/분기문
        // if, 삼항연산자

        int grade = 1;
        // switch문장에서 변수를 저장
        switch (grade) {
            // 변수 값이 일치하면 실행
            case 1:
                System.out.println("1학년");
                // break가 없는 경우 계속해서 다음 문장을 실행
                // if문과 다른 점
                break;
        
            case 2:
                System.out.println("2학년");
                break;
        
            case 3:
                System.out.println("3학년");
                break;
        
            default:
                System.out.println("기본");
                break;
        }

        // 요일 (0-6까지 숫자로 표현된 경우 -> 문자로 변환)
        int 요일 = 0;
        switch (요일) {
            case 0:
                System.out.println("일요일");
                break;
        
            case 1:
                System.out.println("월요일");
                break;
        
            case 2:
                System.out.println("화요일");
                break;
        
            case 3:
                System.out.println("수요일");
                break;
        
            case 4:
                System.out.println("목요일");
                break;
        
            case 5:
                System.out.println("금요일");
                break;
        
            case 6:
                System.out.println("토요일");
                break;
        
            default:
                break;
        }

    }
}
