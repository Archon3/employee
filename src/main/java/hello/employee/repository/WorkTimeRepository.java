package hello.employee.repository;

import hello.employee.entity.WorkTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTimeEntity, Long> {
    List<WorkTimeEntity> findByEmpSeqAndWkBegDateBetween(Long empSeq, String start, String end);
}
