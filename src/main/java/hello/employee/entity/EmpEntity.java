package hello.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "_TDAEmp")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empSeq")
    private Long seq;

    @Column(name = "companySeq")
    private Long companySeq;

    @Column(name = "empName", length = 200)
    private String empName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptSeq")
    private DeptEntity dept;

    /**
     * 연관관계 편의 메소드
     */
    public void setDept(DeptEntity dept) { this.dept = dept; }

}

