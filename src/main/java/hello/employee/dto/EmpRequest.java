package hello.employee.dto;

import hello.employee.entity.Emp;
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

}
