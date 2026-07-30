package ex03.method;

import java.util.Scanner;

import ex03.method.obj.basic;

public class MenuApp {
    public static void main(String[] args) {

        // 사용자의 입력을 받아오는 객체
        Scanner scan = new Scanner(System.in);
    while (true) {
        
        // 1. 메뉴 출력
        basic.printMenu();
        // 2. 사용자로부터 입력받기
        int menu = 0; // 선언과 초기화를 동시에

        // 숫자가 입력될 때까지 반복
        while(true){
            try {
                menu = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("숫자만 입력이 가능합니다");
                scan.nextLine();
            }
        }
        
        System.out.println("menu : " + menu);
        // 3. 입력에 따라 메서드 실행
        if (menu == 1) {
            // bmi
            // 키, 몸무게
            System.out.println("키를 입력해주세요");
            System.out.println("몸무게를 입력해주세요");
        } else if (menu == 2) {
            // 로또
            basic.getLotto();
        } else if (9 == menu) {
            System.out.println("종료되었습니다");
            System.exit(0);
        } else {
            System.out.println("메뉴를 확인해주세요");
        }
        
    }
    }
}
