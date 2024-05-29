package hello.employee.service;

import hello.employee.entity.Emp;
import hello.employee.dto.WorkTimeQueryResponse;
import hello.employee.repository.EmpRepository;
import hello.employee.repository.VacationAppRepository;
import hello.employee.repository.WorkTimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
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
    public List<WorkTimeQueryResponse> getWorkTimeByName(String empName, String frDate, String toDate) {

        List<WorkTimeQueryResponse> responseList = new ArrayList<>();

        Emp emp = empRepository.findByEmpName(empName).get();

        // 출퇴근
        responseList.addAll(getWorkTimes(frDate, toDate, emp));

        // 휴가
        responseList.addAll(getVacations(frDate, toDate, emp));

        return responseList.stream()
                .sorted(Comparator.comparing(WorkTimeQueryResponse::getWkBegDate).reversed())
                .collect(Collectors.toList());
    }

    private List<WorkTimeQueryResponse> getVacations(String ftDate, String toDate, Emp emp) {
        return vacationAppRepository.findByEmpSeqAndWkBegDateBetween(emp.getEmpSeq(), ftDate, toDate)
                .stream()
                .map(vacation -> {
                    WorkTimeQueryResponse response = new WorkTimeQueryResponse(vacation);
                    response.setEmpName(emp.getEmpName());
                    return response;
                })
                .collect(Collectors.toList());
    }

    private List<WorkTimeQueryResponse> getWorkTimes(String ftDate, String toDate, Emp emp) {
        return workTimeRepository.findByEmpSeqAndWkBegDateBetween(emp.getEmpSeq(), ftDate, toDate)
                .stream()
                .map(workTime -> {
                    WorkTimeQueryResponse response = new WorkTimeQueryResponse(workTime);
                    response.setEmpName(emp.getEmpName());
                    return response;
                })
                .collect(Collectors.toList());
    }

}
