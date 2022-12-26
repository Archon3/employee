package hello.crudtest.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dept")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deptId")
    private Long id;

    @Column(name = "companyId")
    private Long companyId;

    @Column(name = "deptName", length = 200)
    private String name;
}
