package hello.employee.repository;

import hello.employee.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Long> {
    Optional<Dept> findByDeptName(String name);
}
