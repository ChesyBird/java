package ex03.method;

import ex03.method.obj.*;

public class BmiApp {
    public static void main(String[] args){
    basic basic = new basic();
    double bmi = basic.getBmi(1.63, 55.5);
    String str = basic.bmiToStr(bmi);

    System.out.println(str);
    }
}
