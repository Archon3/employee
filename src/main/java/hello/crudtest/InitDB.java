package hello.crudtest;

import hello.crudtest.entity.*;
import hello.crudtest.repository.DeptRepository;
import hello.crudtest.repository.EmpRepository;
import hello.crudtest.repository.VacationAppRepository;
import hello.crudtest.repository.WorkTimeRepository;
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
            DeptDto dDto = DeptDto.builder()
                    .companyId(1L)
                    .deptName("전사")
                    .build();

            createDept(dDto);
        }

        public void initEmp() {
            EmpDto eDto1 = EmpDto.builder()
                    .companyId(1L)
                    .empName("홍길동")
                    .build();

            EmpDto eDto2 = EmpDto.builder()
                    .companyId(1L)
                    .empName("철수")
                    .build();

            createEmp(eDto1);
            createEmp(eDto2);
        }

        public void initWorkTime() {

            EmpEntity emp = empRepository.findByName("홍길동").get();

            WorkTimeEntity wt = WorkTimeEntity.builder()
                    .companyId(1L)
                    .emp(emp)
                    .wkBegDate("20221205")
                    .begTime("0900")
                    .wkEndDate("20221216")
                    .endTime("1800")
                    .build();

            workTimeRepository.save(wt);

            VacationAppEntity va = VacationAppEntity.builder()
                    .companyId(1L)
                    .emp(emp)
                    .wkBegDate("20221219")
                    .begTime("0900")
                    .wkEndDate("20221221")
                    .endTime("1800")
                    .build();

            vacationAppRepository.save(va);

        }

        private void createDept(DeptDto data) {
            deptRepository.save(data.toEntity());
        }

        private void createEmp(EmpDto data) {
            EmpEntity entity = data.toEntity();

            // 연관관계 매핑
            DeptEntity dept = deptRepository.findByName("전사").get();
            entity.setDept(dept);

            empRepository.save(entity);
        }
    }
}
