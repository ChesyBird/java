package ex08.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class BuiltinFunction {
    public static void main(String[] args) {
        // BuiltinFunction : 자바에서 미리 만들어 놓은 함수형 인터페이스
        // java.utill.function 패키지에 미리 정의 된 함수형 인터페이스를 이용
        // 매개변수가 없고 반환타입이 없는
        // 매개변수가 있고 반환타입이 없는
        // 매개변수가 있고 반환타입이 있는

        // Runnable 함수형 인터페이스
        // 함수를 작성(인터페이스의 구현체를 만든다 = 람다식으로)
        // 매개변수가 없는 경우 ()생략 불가능
        Runnable tesk = ()->System.out.println("작업을 실행합니다.");

        // Runnable이 가지고있는 하나뿐인 추상메서드를 호출
        tesk.run();

        // 빌트인 함수 이용하기2
        // 반환 있고, 매개변수가 있는 경우 
        // Function<매개변수 타입, 반환 타입>
        // 문자를 숫자로 반환하는 함수
        Function<String, Integer> f = str -> Integer.parseInt(str);

        // 인터페이스가 가지고있는 추상메서드를 실행
        // -> 위에서 정의한 람다식이 실행
        System.out.println(f.apply("123456"));

        // 점수로 비교해서 정렬
        // 람다식을 이용해서 Comparator의 compare함수의 구현체 만들기
        // 학생2명의 점수를 비교 후 반환
        Student s1 = new Student("오미자", 55);
        Student s2 = new Student("이미자", 88);

        // 람다식 밖에서 이미 사용중인 변수명은 사용할 수 없다
        // 함수정의
        Comparator<Student> byScore = (ss1, ss2) -> s1.getScore() - s2.getScore();
        // 함수호출
        System.out.println(byScore.compare(s1, s2));

        // 리스트를 만들고 리스트에 들어있는 학생을 점수로 정렬
        List<Student> list = new ArrayList<>();
        list.add(new Student("오미자", 75));
        list.add(new Student("박미자", 85));
        list.add(new Student("이미자", 55));
        list.add(new Student("아직자", 88));
        list.add(new Student("계속자", 95));

        // Comparator : 함수형 인터페이스를 매개변수로 받고있는 경우
        // 변수에 람다식을 저장하여 넣어도 되고 람다식 자체를 넣어도 된다
        list.sort(byScore);
        // 반환값이 음수면 자리바꿈 - 내림차순 2번째 요소에서 첫번째 요소의 값을 빼면
        list.sort((ss1, ss2) -> ss1.getScore() - ss2.getScore()); // 이쪽을 더 많이 사용

        System.out.println(list); // 오름차순 정렬

        list.sort((ss1, ss2) -> ss2.getScore() - ss1.getScore());

        System.out.println(list); //내림차순 정렬

        // 메서드 참조(Method Reference)
        // 불변의 리스트
        List<String> names = List.of("이미자", "오미자", "아직자");
        // of는 불변의 리스트라 새로운 값을 추가할 수 없다
        // names.add("새로운값");

        names.forEach(str -> System.out.println(str));

        names.forEach(System.out::println);

    }
}
