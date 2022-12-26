package hello.crudtest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpDto {
    private Long empId;

    private Long companyId;

    private String empName;

    private Long deptId;

    private String deptName;

    /* Dto -> Entity */
    public EmpEntity toEntity() {
        return EmpEntity.builder()
                .id(this.empId)
                .companyId(this.companyId)
                .name(this.empName)
                .build();
    }

    /* Entity -> Dto */
    public EmpDto(EmpEntity emp) {
        this.empId = emp.getId();
        this.companyId = emp.getCompanyId();
        this.empName = emp.getName();
        this.deptId = emp.getDept().getId();
        this.deptName = emp.getDept().getName();
    }
}
