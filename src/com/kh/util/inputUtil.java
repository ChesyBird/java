package com.kh.util;

import java.util.Scanner;

public class inputUtil {

    private static Scanner scan = new Scanner(System.in);
    
    // 생성자 접근불가
    // 반환타입 없음. 클래스명과 이름이 같음
    // 기본 생성자
    private inputUtil(){
        System.out.println("기본생성자 접근 금지!");
    }

    public static String getString(String msg){
        System.out.print(msg);
        while(true){
            String text = "";
            // trim(): 앞뒤 공백 제거
            text = scan.nextLine().trim();
            // if(text.equals("")){}
            if(text.isEmpty()){
                // 남은 코드블럭을 실행하지 않고
                // 다음 반복문으로 넘어가기
                continue;
            }

            // 메서드는 반환을 만나면 끝남
            // 나를 호출한 곳으로 반환값을 전달
            return text;
        }
    }
    
    public static int getInt(String msg){
        int i = 0;
        while(true){
            System.out.print(msg);
            try {
                i = scan.nextInt();
                // 숫자만 가지고 가서 엔터가 남아있음
                // 엔터의 제거가 필요함
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요");
                // 오류가 발생했을 때 입력값이 그대로 남아있음
                // 입력값 제거가 필요함
                scan.nextLine();
                continue;
            }
        }
        return i;

    }

    public static double getDouble(String msg){
        double d = 0.0;
        while (true) {
            System.out.print(msg);
            try{
                d = scan.nextDouble();
                scan.nextLine();
                break;
            } catch(Exception e){
                System.out.println("실수를 입력해주세요");
                scan.nextLine();
                continue;
            }
            
        }
        return d;
    }


    // public static void main(String[] args) {
    //     // 정적필드, 정적메서드
    //     // 클래스명.필드명/ 클래스명.메서드명
    //     inputUtil.getString("이름 : ");
    //     inputUtil.getInt("나이 : ");
    //     inputUtil.getString("주소 : ");
    // }
}
