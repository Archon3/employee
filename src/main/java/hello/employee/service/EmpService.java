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

@Service                  // 서비스로 인식하기 위한 어노테이션
@RequiredArgsConstructor  // 생성자 어노테이션
@Slf4j                    // 로그관련 어노테이션
public class EmpService {

    private final EmpRepository empRepository;
    private final DeptRepository deptRepository;

    // 전체조회
    @Transactional(readOnly = true)
    public List<EmpResponse> getEmps() {
        return empRepository.findAll()
                .stream()
                .map(EmpResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmpResponse getEmp(Long empSeq) {
        //Optional : 데이터 Null 여부를 체크할 수 있는 변수
        EmpEntity result = empRepository.findById(empSeq)
                .orElseThrow(NullPointerException::new);

        return new EmpResponse(result);
    }

    // 저장
    @Transactional // 트랜젝션 어노테이션
    public EmpResponse createEmp(EmpRequest request) {
        EmpEntity emp = request.toEntity();

        //연관관계 매핑
        DeptEntity dept = deptRepository.findById(request.getDeptSeq()).get();
        emp.setDept(dept);

        EmpEntity result = empRepository.save(emp);
        return new EmpResponse(result);
    }

    // 삭제
    @Transactional
    public void deleteEmp(Long empSeq) { empRepository.deleteById(empSeq); }
}
