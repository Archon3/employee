package hello.crudtest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "emp")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private Long id;

    @Column(name = "companyId")
    private Long companyId;

    @Column(name = "empName", length = 200)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId")
    private DeptEntity dept;

    /**
     * 연관관계 편의 메소드
     */
    public void setDept(DeptEntity dept) { this.dept = dept; }

}

