package hello.employee.repository;

import hello.employee.entity.VacationAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationAppRepository extends JpaRepository<VacationAppEntity, Long> {
    List<VacationAppEntity> findByEmpSeqAndWkBegDateBetween(Long empSeq, String start, String end);
}
