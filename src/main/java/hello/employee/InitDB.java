package hello.employee;

import hello.employee.dto.DeptRequest;
import hello.employee.dto.EmpRequest;
import hello.employee.entity.*;
import hello.employee.mapper.DeptMapper;
import hello.employee.mapper.EmpMapper;
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
        private final EmpMapper empMapper;
        private final DeptMapper deptMapper;

        public void initDept() {
            DeptRequest dDto = DeptRequest.builder()
                    .companySeq(1L)
                    .deptName("전사")
                    .build();

            createDept(dDto);
        }

        public void initEmp() {
            EmpRequest request1 = EmpRequest.builder()
                    .companySeq(1L)
                    .empName("홍길동")
                    .build();

            EmpRequest request2 = EmpRequest.builder()
                    .companySeq(1L)
                    .empName("철수")
                    .build();

            createEmp(request1);
            createEmp(request2);
        }

        public void initWorkTime() {
            Emp emp = empRepository.findByEmpName("홍길동").get();

            WorkTime wt1 = WorkTime.builder()
                    .companySeq(1L)
                    .empSeq(emp.getEmpSeq())
                    .wkBegDate("20240502")
                    .begTime("0900")
                    .wkEndDate("20240502")
                    .endTime("1800")
                    .build();

            workTimeRepository.save(wt1);

            WorkTime wt2 = WorkTime.builder()
                    .companySeq(1L)
                    .empSeq(emp.getEmpSeq())
                    .wkBegDate("20240507")
                    .begTime("0900")
                    .wkEndDate("20240507")
                    .endTime("1800")
                    .build();

            workTimeRepository.save(wt2);

            VacationApp va = VacationApp.builder()
                    .companySeq(1L)
                    .empSeq(emp.getEmpSeq())
                    .wkBegDate("20240503")
                    .begTime("0900")
                    .wkEndDate("20240503")
                    .endTime("1800")
                    .build();

            vacationAppRepository.save(va);

        }

        private void createDept(DeptRequest request) {
            Dept dept = deptMapper.toDeptCreate(request);
            deptRepository.save(dept);
        }

        private void createEmp(EmpRequest request) {
            Emp emp = empMapper.toEmp(request);

            // 연관관계 매핑
            Dept dept = deptRepository.findByDeptName("전사").get();
            emp.setDept(dept);

            empRepository.save(emp);
        }
    }
}
