package hello.employee.repository;

import hello.employee.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
    Optional<Emp> findByEmpName(String name);
}
