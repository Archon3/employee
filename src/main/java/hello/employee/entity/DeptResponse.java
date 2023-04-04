package hello.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptResponse {
    private Long deptSeq;

    private Long companySeq;

    private String deptName;

    /* Entity -> Dto */
    public DeptResponse(DeptEntity data) {
        this.deptSeq = data.getSeq();
        this.companySeq = data.getCompanySeq();
        this.deptName = data.getDeptName();
    }
}
