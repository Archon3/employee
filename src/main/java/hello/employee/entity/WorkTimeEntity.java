package hello.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "_TXPRWkEmpWorkTime")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wkSeq")
    private Long seq;

    @Column(name = "CompanySeq")
    private Long companySeq;

    @Column(name = "EmpSeq")
    private Long empSeq;

    @Column(name = "WkBegDate")
    private String wkBegDate;

    @Column(name = "BegTime")
    private String begTime;

    @Column(name = "WkEndDate")
    private String wkEndDate;

    @Column(name = "EndTime")
    private String endTime;

}
