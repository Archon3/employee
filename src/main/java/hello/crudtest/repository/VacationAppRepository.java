package hello.crudtest.repository;

import hello.crudtest.entity.VacationAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacationAppRepository extends JpaRepository<VacationAppEntity, Long> {
    List<VacationAppEntity> findByEmp_NameAndWkBegDateBetween(String name, String start, String end);
}
