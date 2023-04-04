package hello.employee.repository;

import hello.employee.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Long> {
    Optional<EmpEntity> findByEmpName(String name);
}
