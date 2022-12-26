package hello.crudtest.repository;

import hello.crudtest.entity.WorkTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTimeEntity, Long> {
    List<WorkTimeEntity> findByEmp_NameAndWkBegDateBetween(String name, String start, String end);
}
