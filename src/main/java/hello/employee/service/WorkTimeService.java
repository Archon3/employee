package hello.employee.service;

import hello.employee.entity.EmpEntity;
import hello.employee.entity.WorkTimeQueryDto;
import hello.employee.repository.EmpRepository;
import hello.employee.repository.VacationAppRepository;
import hello.employee.repository.WorkTimeRepository;
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

    private final EmpRepository empRepository;
    private final VacationAppRepository vacationAppRepository;
    private final WorkTimeRepository workTimeRepository;

    @Transactional(readOnly = true)
    public List<WorkTimeQueryDto> queryByName(String empName, String begDate, String endDate) {

        List<WorkTimeQueryDto> resultList = new ArrayList<>();

        EmpEntity emp = empRepository.findByEmpName(empName).get();

        // 출퇴근
        resultList.addAll(getWorkTimes(begDate, endDate, emp));

        // 휴가
        resultList.addAll(getVacations(begDate, endDate, emp));

        return resultList;
    }

    private List<WorkTimeQueryDto> getVacations(String begDate, String endDate, EmpEntity emp) {
        return vacationAppRepository.findByEmpSeqAndWkBegDateBetween(emp.getSeq(), begDate, endDate)
                .stream()
                .map(vacation -> {
                    WorkTimeQueryDto response = new WorkTimeQueryDto(vacation);
                    response.setEmpName(emp.getEmpName());
                    return response;
                })
                .collect(Collectors.toList());
    }

    private List<WorkTimeQueryDto> getWorkTimes(String begDate, String endDate, EmpEntity emp) {
        return workTimeRepository.findByEmpSeqAndWkBegDateBetween(emp.getSeq(), begDate, endDate)
                .stream()
                .map(workTime -> {
                    WorkTimeQueryDto response = new WorkTimeQueryDto(workTime);
                    response.setEmpName(emp.getEmpName());
                    return response;
                })
                .collect(Collectors.toList());
    }

}
