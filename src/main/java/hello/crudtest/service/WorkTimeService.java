package hello.crudtest.service;

import hello.crudtest.entity.WorkTimeQueryDto;
import hello.crudtest.repository.VacationAppRepository;
import hello.crudtest.repository.WorkTimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WorkTimeService {

    private final VacationAppRepository vacationAppRepository;
    private final WorkTimeRepository workTimeRepository;

    @Transactional(readOnly = true)
    public List<WorkTimeQueryDto> queryByName(String empName) {

        List<WorkTimeQueryDto> resultList = new ArrayList<>();

        // 출퇴근
        List<WorkTimeQueryDto> wtList = workTimeRepository.findByEmp_NameAndWkBegDateBetween(empName, "20221201", "20221231")
                .stream()
                .map(WorkTimeQueryDto::new)
                .collect(Collectors.toList());

        resultList.addAll(wtList);

        // 휴가
        List<WorkTimeQueryDto> vaList = vacationAppRepository.findByEmp_NameAndWkBegDateBetween(empName, "20221201", "20221231")
                .stream()
                .map(WorkTimeQueryDto::new)
                .collect(Collectors.toList());

        resultList.addAll(vaList);

        return resultList;
    }

}
