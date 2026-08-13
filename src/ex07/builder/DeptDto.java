package ex07.builder;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
// @NoArgsConstructor
// @AllArgsConstructor
@Builder   // 생성자 없이 Builder를 통해 생성하는 것 -> new 안씀
public class DeptDto {
    private String deptId;
    private String deptCode;
    @NonNull
    private String locationId;

}
