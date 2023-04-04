package hello.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpResponse {
    private Long empSeq;

    private Long companySeq;

    private String empName;

    private Long deptSeq;

    private String deptName;

    /* Entity -> Dto */
    public EmpResponse(EmpEntity emp) {
        this.empSeq = emp.getSeq();
        this.companySeq = emp.getCompanySeq();
        this.empName = emp.getEmpName();
        this.deptSeq = emp.getDept().getSeq();
        this.deptName = emp.getDept().getDeptName();
    }
}
