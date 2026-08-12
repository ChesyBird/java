package ex05.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
    String empId;
    String empName;
    int salary;
    String empNo;
    // 날짜
    // 마이바티스는 객체를 자동으로 생성
    // 컬럼이름 - 소문자로 + 카멜표기법
    LocalDate hireDate;
    String entDate;
    
    

    // @Override
    // public String toString() {
    //     return empId + empName + salary + empNo + hireDate + entDate;
    // }

    @Override
    public String toString() {

        // 입사일은 다 입력되어 있지만
        // 퇴사일은 없는 경우가 많음
        // -> 퇴사일이 비어있으면 오늘 날짜를 퇴사일로 하여 계산
        LocalDate ent;
        if(entDate == null){
            ent = LocalDate.now();
        } else {
            // 문자열을 LocalDate로 반환
            ent = LocalDate.parse(entDate);
        }
        
        System.out.println("입사일 : " + hireDate);
        System.out.println("퇴사일 : " + ent);

        // 두 날짜 사이의 개월수를 계산
        long workingMonths = ChronoUnit.MONTHS.between(hireDate, ent);

        return "%s(%s)님 근무개월수는 %d개월입니다.".formatted(empId, empName, workingMonths);

    }

}
