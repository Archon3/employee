package hello.employee;

import hello.employee.entity.*;
import hello.employee.repository.DeptRepository;
import hello.employee.repository.EmpRepository;
import hello.employee.repository.VacationAppRepository;
import hello.employee.repository.WorkTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.initDept();
        initService.initEmp();
        initService.initWorkTime();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final DeptRepository deptRepository;
        private final EmpRepository empRepository;
        private final VacationAppRepository vacationAppRepository;
        private final WorkTimeRepository workTimeRepository;

        public void initDept() {
            DeptRequest dDto = DeptRequest.builder()
                    .companySeq(1L)
                    .deptName("전사")
                    .build();

            createDept(dDto);
        }

        public void initEmp() {
            EmpRequest eDto1 = EmpRequest.builder()
                    .companySeq(1L)
                    .empName("홍길동")
                    .build();

            EmpRequest eDto2 = EmpRequest.builder()
                    .companySeq(1L)
                    .empName("철수")
                    .build();

            createEmp(eDto1);
            createEmp(eDto2);
        }

        public void initWorkTime() {

            EmpEntity emp = empRepository.findByEmpName("홍길동").get();

            WorkTimeEntity wt = WorkTimeEntity.builder()
                    .companySeq(1L)
                    .empSeq(emp.getSeq())
                    .wkBegDate("20230306")
                    .begTime("0900")
                    .wkEndDate("20230317")
                    .endTime("1800")
                    .build();

            workTimeRepository.save(wt);

            VacationAppEntity va = VacationAppEntity.builder()
                    .companySeq(1L)
                    .empSeq(emp.getSeq())
                    .wkBegDate("20230320")
                    .begTime("0900")
                    .wkEndDate("20230321")
                    .endTime("1800")
                    .build();

            vacationAppRepository.save(va);

        }

        private void createDept(DeptRequest data) {
            deptRepository.save(data.toEntity());
        }

        private void createEmp(EmpRequest data) {
            EmpEntity entity = data.toEntity();

            // 연관관계 매핑
            DeptEntity dept = deptRepository.findByDeptName("전사").get();
            entity.setDept(dept);

            empRepository.save(entity);
        }
    }
}
