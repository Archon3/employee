package hello.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpRequest {
    private Long empSeq;

    private Long companySeq;

    private String empName;

    private Long deptSeq;

    private String deptName;

    /* Dto -> Entity */
    public EmpEntity toEntity() {
        return EmpEntity.builder()
                .seq(this.empSeq)
                .companySeq(this.companySeq)
                .empName(this.empName)
                .build();
    }
}
