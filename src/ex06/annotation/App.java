package ex06.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.kh.inherit.practice.Employee;

public class App {
    public static void main(String[] args) {
        // 클래스 -> new 클래스 -> 객체 생성
        // 1. 객체로부터 클래스의 정보를 조사
        Employee emp = 
            new Employee("미자", 22, 150, 55, 1000000, "어딘가");

        // Class의 정보를 얻어오는 2가지 방법
        Class<?> clazz1 = Employee.class; // 클래스로부터 직접얻기
        Class<?> clazz = emp.getClass(); //객체의 메서드로부터 얻기

        System.out.println("clazz1 == clazz " + (clazz1 == clazz));

        // 선언된 필드의 목록을 조회
        // getDeclatedFields() : private 필드에 접근하기 위해 사용
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            // 접근제한자 -> 숫자에서 문자로
            String modifier = Modifier.toString(field.getModifiers()); //정수를 "private"같은 문자열로 반환 
            // 필드의 선언부
            System.out.println("필드의 선언부 : " + modifier + " " + field.getType() + " " + field.getName());

            // 어노테이션이 붙어 있는지 확인
            if(field.isAnnotationPresent(Required.class)){
                System.out.println("Required 어노테이션이 붙어있는 필드");
                System.out.println("필수 입력입니다!");
            }
        }

        System.out.println("=== 검증기를 통해 검증하기 ===");
        try {
            Validation.검증(emp);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }

        /* 권장되지는 않지만 Exception 하나로 예외 모두를 퉁칠 수 있음
        try {
            Validation.검증(emp);

        } catch (Exception e) {
            e.printStackTrace();

        }*/

    }
}
