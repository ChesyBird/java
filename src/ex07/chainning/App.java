package ex07.chainning;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        // 메서드 체이닝
        // 여러 메서드를 마침표로 연결하여 연속적으로 호출하는 프로그래밍 패턴

        // String객체의 메서드를 이용해서 공백을 제거하고 대문자로 변환
        String str = "   user123  ";
        // 공백 제거된 값을 반환 - String 타입 반환
        // 자기 자신을 직접 변환, 값을 만들어서 반환
        // str = str.trim();
        // toUpperCase : 모두 대문자로 변경
        // str = str.toUpperCase();
        
        str = str.trim().toUpperCase();
        System.out.println(str);

        // 공백제거, [Error] -> 🧨, 10글자만 출력(substring)
        String str1 = "  [Error] Connection Failed!  ";

        // str1 = str1.substring(0, 10);
        // str1 = str1.trim();
        // str1 = str1.replace("Error", "E");
        // str1 = str1.substring(0, 10);
        
        str1 = str1.trim()
            .replace("Error", "E")
            .substring(0, 10);
        System.out.println(str1);

        double a = 0.1;
        double b = 0.2;

        // 정밀한 연산이 필요한 경우 double, float 방식을 사용하면 안됨
        System.out.println(a + b);

        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        
        // 실수의 연산
        System.out.println(bd1.add(bd2));

        // 날짜/시간 다루기
        // 현재 날짜
        LocalDate today = LocalDate.now();
        // 년, 월, 일
        LocalDate birthDay = LocalDate.of(1996, 10, 07);
        // yyyy-MM-dd(기본 형식)
        LocalDate hireDate = LocalDate.parse("2016-05-05");
        System.out.println(today);
        System.out.println(birthDay);
        System.out.println(hireDate);

        System.out.println("plusDays : " + today.plusDays(10));
        System.out.println("minusDays : " + today.minusDays(10));
        System.out.println(today.getYear());
        System.out.println(today.getMonth());
        System.out.println(today.getDayOfMonth());

        // 출력 형식을 지정하여 출력하기
        // mm - 시간
        // MM - 월
        // 이것이 자바다 545p
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        System.out.println(today.format(formatter));

        // 현재 시간
        System.out.println(LocalTime.now());
        // 현재시간, 날짜
        System.out.println(LocalDateTime.now());

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a hh:mm");

        System.out.println(now.format(formatterA));

    }
}
