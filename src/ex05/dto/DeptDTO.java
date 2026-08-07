package ex05.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 테이블에서 조회된 값을 담기 위해 필드를 선언한다

// @: 어노테이션
// lombok라이브러리는 set, get, 생성자를 어노테이션으로 자동생성해준다
@Data // setter, getter
@AllArgsConstructor // 매개변수 생성자
@NoArgsConstructor // 기본 생성자
public class DeptDTO {
    private String deptId;
    private String deptCode;
    private String locationId;

}
