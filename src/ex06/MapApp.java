package ex06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kh.inherit.practice.Employee;

import ex05.dto.DeptDTO;

public class MapApp {
    public static void main(String[] args) {
        // 데이터를 키와 값으로 저장
        // 여러타입의 데이터를 저장하는 이름으로 사용할 수 있다
        // ex)게시물 조회 - 리스트, 페이지정보 ...
        // 키의 타입 - 문자열多, 값의 타입
        // Map은 인터페이스 : 직접 생성할 수 없다! -> 인터페이스의 구현체(HashMap)사용
        // Map<키의 타입, 값의 타입>
        Map<String, Employee> map = new HashMap<>();

        // 키-값 쌍으로 데이터를 관리
        // 키는 중복될 수 없다 - 덮어써버림!
        map.put("사원1", new Employee("오미자1", 23, 0, 0, 0, "d1"));
        map.put("사원2", new Employee("오미자2", 23, 0, 0, 0, "d1"));
        map.put("사원3", new Employee("오미자3", 23, 0, 0, 0, "d1"));

        // map의 데이터를 꺼내올 떄는 키값을 매개변수로 사용한다
        // get : 키에 저장된 값을 반환
        System.out.println(map.get("사원1"));
        System.out.println(map.get("사원2"));
        System.out.println(map.get("사원3"));

        System.out.println(map.containsKey("사원"));

        // map에 있는 사원이라는 키를 사용하는 값을 꺼내어 확인
        System.out.println(map.get("사원"));
        if(map.get("사원") == null){
            System.out.println("사원은 존재하지 않습니다.");
        }
        // containsKey 메서드를 이용하여 확인
        if(!map.containsKey("사원")){
            System.out.println("사원은 존재하지 않습니다.");
        }

        Map<String, Object> map1 = new HashMap<>();
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("철수", 23, 0, 0, 0, null));
        list.add(new Employee("영희", 21, 0, 0, 0, null));
        list.add(new Employee("바둑이", 28, 0, 0, 0, null));
        
        map1.put("title", "map을 학습중입니다. ");
        map1.put("dept", new DeptDTO("D1", "인사관리부", "S1"));
        map1.put("list", list);

        String title = (String)map1.get("title");
        System.out.println(title);
        System.out.println((String)map1.get("title"));

        // 리스트를 꺼내서 출력해보기
        // List<Employee> mapList = (List<Employee>)map1.get("list");
        // System.out.println(mapList);

        // map이 가지고있는 키의 목록 확인
        Set<String> keys = map.keySet();
        System.out.println(keys);

        // map에 담겨있는 키의 목록을 조회해서 값을 확인
        for(String key : keys){
            System.out.println(map.get(key));
        }

        // 리스트 : 인덱스로 관리, 보통 한가지 타입을 담는다

    }
}
