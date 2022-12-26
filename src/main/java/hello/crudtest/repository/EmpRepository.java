package hello.crudtest.repository;

import hello.crudtest.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Long> {
    Optional<EmpEntity> findByName(String name);
}
