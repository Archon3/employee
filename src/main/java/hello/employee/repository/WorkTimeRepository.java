package hello.employee.repository;

import hello.employee.entity.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTime, Long> {
    List<WorkTime> findByEmpSeqAndWkBegDateBetween(Long empSeq, String frDate, String toDate);
}
