package hello.employee.repository;

import hello.employee.entity.VacationApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationAppRepository extends JpaRepository<VacationApp, Long> {
    List<VacationApp> findByEmpSeqAndWkBegDateBetween(Long empSeq, String frDate, String toDate);
}
