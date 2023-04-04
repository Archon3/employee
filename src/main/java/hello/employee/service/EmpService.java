package hello.employee.service;

import hello.employee.entity.DeptEntity;
import hello.employee.entity.EmpRequest;
import hello.employee.entity.EmpEntity;
import hello.employee.entity.EmpResponse;
import hello.employee.repository.DeptRepository;
import hello.employee.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmpService {

    private final EmpRepository empRepository;
    private final DeptRepository deptRepository;

    @Transactional(readOnly = true)
    public List<EmpResponse> getEmps() {
        return empRepository.findAll()
                .stream()
                .map(EmpResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmpResponse getEmp(Long empSeq) {
        //Optional
        EmpEntity result = empRepository.findById(empSeq)
                .orElseThrow(NullPointerException::new);

        return new EmpResponse(result);
    }

    public EmpResponse createEmp(EmpRequest request) {

        EmpEntity emp = request.toEntity();

        //연관관계 매핑
        DeptEntity dept = deptRepository.findById(request.getDeptSeq()).get();
        emp.setDept(dept);

        EmpEntity result = empRepository.save(emp);
        return new EmpResponse(result);
    }

    @Transactional
    public void deleteEmp(Long empSeq) { empRepository.deleteById(empSeq); }
}
