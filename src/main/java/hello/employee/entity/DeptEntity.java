package hello.employee.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "_TDADept")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptSeq")
    private Long seq;

    @Column(name = "companySeq")
    private Long companySeq;

    @Column(name = "deptName", length = 200)
    private String deptName;
}
