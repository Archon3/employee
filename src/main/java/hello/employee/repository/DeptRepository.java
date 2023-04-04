package hello.employee.repository;

import hello.employee.entity.DeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeptRepository extends JpaRepository<DeptEntity, Long> {
    Optional<DeptEntity> findByDeptName(String name);
}
