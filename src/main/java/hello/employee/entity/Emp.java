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
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empSeq")
    private Long empSeq;

    @Column(name = "companySeq")
    private Long companySeq;

    @Column(name = "empName", length = 200)
    private String empName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptSeq")
    private Dept dept;

    /**
     * 연관관계 편의 메소드
     */
    public void setDept(Dept dept) { this.dept = dept; }

    public void setName(String name) {this.empName = name; }

}

