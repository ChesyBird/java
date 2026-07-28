package ex03.method.obj;

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
    public double getBmi(double h, double w) {
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
    public String bmiToStr(double bmi){
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

    
    // static 키워드: 프로그램 시작과 동시에 메모리에 올라감
    // 생성하지 않고 사용할 수 있다
    // 자기들끼리도 호출할 수 있다

}
