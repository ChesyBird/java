package ex03.method.obj;

//import java.lang.reflect.Array;
import java.util.Arrays;

public class basic {

    public void info(String name, int age, double height) {
        // 숫자를 나타내는 타입
        // 정수- int
        // 실수- double
        System.out.println("""
                Name : %s
                Age : %d
                Height : %.2f
                """.formatted(name, age, height));
    }

    // 소수점의 경우 % 뒤에 ''.표기하고싶은 소수점 밑 개수'로 설정 가능
    public String getInfo(String name, int age, double height) {
        return "Name : %s Age : %d Heignt : %.2f".formatted(name, age, height);
    }

    // 실수 - kg, m
    public static double getBmi(double h, double w) {
        double bmi = 0.0;
        // bmi = 체중/(신장(m)*신장(m))
        // 당신의 키, 몸무게, bmi, 정상입니다.
        bmi = w/(h*h);

        return bmi;
    }
    
    // 형변환 연습!
    // 정수 - kg, cm
    //public String getBmiStr(int h, int w) {
    //    double bmi = 0.0;
    //    bmi = w/(((double)h/100)*((double)h/100));
    //
    //    String bmiStr = """
    //        키: %d cm, 몸무게: %d kg, bmi: %f
    //        당신은 %s 입니다.
    //    """.formatted(h, w, bmi, "정상");
    //    // bmi = 체중/(신장(m)*신장(m))
    //    // 당신의 키, 몸무게, bmi, 정상입니다.

    //    return bmiStr;
    //}

    /**
     * bmi를 매개변수로 받아서 문자로 변환
     * @param bmi
     */
    public static String bmiToStr(double bmi){
        // 변수를 초기화하지 않으면 사용 불가
        String str;

        str = "";

        if(bmi<18.5){
            str = "저체중";
        }else if(bmi<=22.9){
            str = "정상";
        }else if(bmi<=24.9){
            str = "비만전단계";
        }else{
            str = "비만";
        };
        
        return str;
    }

    
    
    // 정적 메서드/정적 필드(static)
    // static 키워드: 프로그램 시작과 동시에 메모리에 올라감
    // 객체를 생성하지 않고 클래스이름.메서드/필드 로 이용 ㄱㄴ
    // 자기들끼리도 호출할 수 있다

    // + getLotto() - 1~46까지 임의의 숫자를 뽑아 배열에 담아서 반환
    public static int[] ex01(){
        
        
        // 배열 -> 컬렉션프레임워크(List, Set, Map)
        // 1. 타입이 같은 데이터를 여러개 보관
        // 2. 길이(갯수)가 정해져있다
        
        // 배열을 만들 때 값을 넣고 배열을 만드는 방법
        int[] lotto = {1,2,3,4,5,6};
        lotto[0] = 1;
        // 방의 갯수를 지정해서 배열을 만드는 방법
        int[] lotto1 = new int[6];
        lotto1[0] = 1;
        
        // 배열의 선언과 초기화
        //String str[] = {"이미자", "오미자"};
        
        // 배열의 선언
        // 배열은 타입의 기본값으로 초기화
        String str1[] = new String[2];
        // 배열의 초기화
        str1[0] = "이미자";
        
        // 0-1미만의 임의의 실수를 만들어주는 기능(로또)
        // 유틸리티
        //double random = Math.random()*46 + 1;
        // 형변환
        // double타입 -> int타입
        //int num = (int)random;

        // 반복문을 이용해서 배열에 접근 > 값을 출력
        // 초기값, 비교, 증감값
        // 배열의 길이: 배열의변수명.length
        for(int i=0; i<str1.length; i++){
            System.out.println("str1 : " + str1[i]);
        }

        // 향상된 for문
        String lottoStr = "";
        for(int num1:lotto1){
            // System.out.print(num1 + ", ");
            lottoStr += num1 + ", ";
        }

        System.out.println("lotto : " + lottoStr);
        System.out.println(lottoStr.substring(0, lottoStr.length()-2));

        System.out.println();
        System.out.println("hello".length());
        System.err.println("hello".substring(2));
        // 시작인덱스 포함, 끝인덱스 불포함
        System.out.println("hello".substring(0,3));
        // 해당 문자열이 처음 나오는 위치 반환
        // 해당 문자열이 없으면 -1을 반환
        System.out.println("hello".indexOf("1"));
        if("hello".indexOf("l") > -1){
            System.out.println("문자가 포함되어 있어요!");
        }
        // 앞 뒤의 공백을 모두 제거
        System.out.println("  abc123 ".trim());
        System.out.println("hello".replace("l", "o"));
        System.out.println("abc".equals("abc"));

        String a = "abc";
        String b = "abc";

        System.out.println("a==b : " + (a == b));
        System.out.println("a==b : " + a.equals(b));

        String aa = new String("abc");
        String bb = new String("abc");

        System.out.println("aa == bb : " + (aa == bb));
        // 문자열의 값을 비교할때는 equals 메서드를 이용해야 한다
        System.out.println("aa == bb : " + aa.equals(bb));

        // 타입의 기본값
        // 필드를 초기화하지 않는 경우 기본값이 들어간다
        // 배열의 값을 초기화하지 않는 경우
        // 참조타입의 기본값 = null
        //String name = null;
        // 예외를 처리하지 않으면 프로그램이 비정상적으로 종료
        // -> try/catch
        // System.out.println(name.length()); -> nullPointException

        // if(name != null){
        //     System.out.println(name.length());
        // } else {
        //     System.out.println("name은 null입니다!!");
        // }
            
        String res = "Y";
        // 문자열이 Y이면 계속 실행
        if(res != null && res.equals("Y")){

        }
        // 리터럴이 먼저 오면, null 체크를 할 필요가 없다
        // 대소문자를 구분하지 않고 비교
        if("y".equalsIgnoreCase(res)){
            System.out.println("Y비교 - 대소문자를 가리지 않아요!");
        }

        return lotto;
    }

    // + getLotto() - 1-46까지 임의의 숫자를 뽑아 배열에 담아서 반환
    // 접근제한자 반환타입 메서드명(매개변수T/N, ..){}
    public static int[] getLotto(){
        // 1. 정수(숫자) 6개를 저장할 수 있는 배열을 만들고 반환
        int[] lotto = new int[6];

        // i = 0~5 1씩 증가하면서 코드블럭 실행
        for(int i=0; i<lotto.length; i++){
            
            lotto[i] = (int)(Math.random()*45) + 1;

            // 임의의 번호를 뽑아 변수에 저장
            // 중복된 값이 있는지 확인
            for(int j=0; j<i; j++){
                // lotto[i]와 lotto[j]를 비교
                if(lotto[i] == lotto[j]){
                    System.out.println(Arrays.toString(lotto));
                    System.out.println("중복되었어요!");
                    i--;
                    break;
                }
            }

        }

        
        // 배열의 요소의 값을 출력
        // Arrays.toString(lotto);
        
        System.out.println(Arrays.toString(lotto));
        
        return lotto;
        
    }
    
    public static void printMenu(){
        System.out.println("""
                1.BMI계산기
                2.로또생성기
                9.종료
                
                메뉴를 선택해주세요.
                """);
    }

    public static void main(String[] args) {
        // ex01();

        // 정적메서드 호출 방식 <-> new로 생성하는 방식: 인스턴스
        // basic.getLotto();
        
        printMenu();
    }

}
