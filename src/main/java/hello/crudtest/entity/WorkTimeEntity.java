package hello.crudtest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "workTime")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wkId")
    private Long id;

    @Column(name = "companyId")
    private Long companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empId")
    private EmpEntity emp;

    private String wkBegDate;

    private String begTime;

    private String wkEndDate;

    private String endTime;

}
