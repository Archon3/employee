package hello.employee.dto;

import hello.employee.entity.VacationApp;
import hello.employee.entity.WorkTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkTimeQueryResponse {

    private Long empSeq;

    private String empName;

    private String type;

    private String wkBegDate;

    private String begTime;

    private String wkEndDate;

    private String endTime;

    public WorkTimeQueryResponse(WorkTime entity) {
        this.empSeq = entity.getEmpSeq();
        this.type = "work";
        this.wkBegDate = entity.getWkBegDate();
        this.begTime = entity.getBegTime();
        this.wkEndDate = entity.getWkEndDate();
        this.endTime = entity.getEndTime();
    }

    public WorkTimeQueryResponse(VacationApp entity) {
        this.empSeq = entity.getEmpSeq();
        this.type = "vacation";
        this.wkBegDate = entity.getWkBegDate();
        this.begTime = entity.getBegTime();
        this.wkEndDate = entity.getWkEndDate();
        this.endTime = entity.getEndTime();
    }
}
