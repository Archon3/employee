package hello.crudtest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptDto {
    private Long deptId;

    private Long companyId;

    private String deptName;

    /* Dto -> Entity */
    public DeptEntity toEntity() {
        return DeptEntity.builder()
                .id(this.deptId)
                .companyId(this.companyId)
                .name(this.deptName)
                .build();
    }

    /* Entity -> Dto */
    public DeptDto(DeptEntity data) {
        this.deptId = data.getId();
        this.companyId = data.getCompanyId();
        this.deptName = data.getName();
    }
}
