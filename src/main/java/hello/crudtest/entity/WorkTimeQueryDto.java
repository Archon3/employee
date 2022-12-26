package hello.crudtest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkTimeQueryDto {

    private Long empId;

    private String empName;

    private String type;

    private String wkBegDate;

    private String begTime;

    private String wkEndDate;

    private String endTime;

    public WorkTimeQueryDto(WorkTimeEntity entity) {
        this.empId = entity.getEmp().getId();
        this.empName = entity.getEmp().getName();
        this.type = "work";
        this.wkBegDate = entity.getWkBegDate();
        this.begTime = entity.getBegTime();
        this.wkEndDate = entity.getWkEndDate();
        this.endTime = entity.getEndTime();
    }

    public WorkTimeQueryDto(VacationAppEntity entity) {
        this.empId = entity.getEmp().getId();
        this.empName = entity.getEmp().getName();
        this.type = "vacation";
        this.wkBegDate = entity.getWkBegDate();
        this.begTime = entity.getBegTime();
        this.wkEndDate = entity.getWkEndDate();
        this.endTime = entity.getEndTime();
    }
}
