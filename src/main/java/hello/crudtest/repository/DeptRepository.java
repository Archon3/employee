package hello.crudtest.repository;

import hello.crudtest.entity.DeptEntity;
import hello.crudtest.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeptRepository extends JpaRepository<DeptEntity, Long> {
    Optional<DeptEntity> findByName(String name);
}
