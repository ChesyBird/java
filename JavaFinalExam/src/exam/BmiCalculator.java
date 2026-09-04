package exam;

import exam.util.InputUtil;

public class BmiCalculator {
    public static void main(String[] args) {
        String answer;
        do{
            get();
            answer = InputUtil.getString("계속 하시겠습니까? (y/n): ");

            if(answer.equals("n")){
                System.out.println("프로그램을 종료합니다.");
            }
        } while (answer.equals("y"));
        
        
    }
    
    public static String bmiToStr(double bmi){
        // 변수를 초기화하지 않으면 사용 불가
        String str;
        
        str = "";
        
        if(bmi<18.5){
            str = "저체중";
        }else if(bmi<23){
            str = "정상";
        }else if(bmi<25){
            str = "과체중";
        }else if(bmi<30){
            str = "비만";
        }else {
            str = "고도비만";
        };
        
        return str;
    }
    
    public static void get(){
        double h = InputUtil.getDouble("키를 입력하세요(cm 또는 m): ");
        double w = InputUtil.getDouble("몸무게(kg)를 입력하세요: ");
        
        if (h > 3) {
        h = h / 100;
        }
        double bmi = w/(h*h);

        System.out.println("BMI: %.2f".formatted(bmi));
        System.out.println("판정: " + bmiToStr(bmi));

    }
}
