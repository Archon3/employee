package hello.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptRequest {
    private Long deptSeq;

    private Long companySeq;

    private String deptName;

    /* Dto -> Entity */
    public DeptEntity toEntity() {
        return DeptEntity.builder()
                .seq(this.deptSeq)
                .companySeq(this.companySeq)
                .deptName(this.deptName)
                .build();
    }
}
