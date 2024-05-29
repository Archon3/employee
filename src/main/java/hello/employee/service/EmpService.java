package hello.employee.service;

import hello.employee.entity.Dept;
import hello.employee.dto.EmpRequest;
import hello.employee.entity.Emp;
import hello.employee.dto.EmpResponse;
import hello.employee.exception.CommonException;
import hello.employee.mapper.EmpMapper;
import hello.employee.repository.DeptRepository;
import hello.employee.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static hello.employee.exception.ExceptionType.*;

@Service                  // 서비스로 인식하기 위한 어노테이션
@RequiredArgsConstructor  // 생성자 어노테이션
@Slf4j                    // 로그관련 어노테이션
public class EmpService {

    private final EmpRepository empRepository;
    private final DeptRepository deptRepository;
    private final EmpMapper empMapper;

    // 전체조회
    @Transactional(readOnly = true)
    public List<EmpResponse> getEmps() {
        return empMapper.toEmpResponseList(empRepository.findAll());
    }

    @Transactional(readOnly = true)
    public EmpResponse getEmp(Long empSeq) {
        //Optional : 데이터 Null 여부를 체크할 수 있는 변수
        Emp result = empRepository.findById(empSeq)
                .orElseThrow(NullPointerException::new);

        return empMapper.toEmpResponse(result);
    }

    // 저장
    @Transactional // 트랜젝션 어노테이션
    public EmpResponse createEmp(EmpRequest request) {
        Emp emp = empMapper.toEmpCreate(request);

        //연관관계 매핑
        Dept dept = deptRepository.findById(request.getDeptSeq()).get();
        emp.setDept(dept);

        Emp result = empRepository.save(emp);
        return empMapper.toEmpResponse(result);
    }

    // 수정 - best practice
    @Transactional
    public EmpResponse updateEmpName(EmpRequest request) {
        Emp emp = empRepository.findById(request.getEmpSeq())
                .orElseThrow(() -> CommonException.of(DATA_NOT_FOUND));

        emp.setName(request.getEmpName());
        Emp result = empRepository.save(emp);
        return empMapper.toEmpResponse(result);
    }

    // 수정
    @Transactional
    public EmpResponse updateEmp(EmpRequest request) {
        Emp emp = empMapper.toEmp(request);

        //연관관계 매핑
        Dept dept = deptRepository.findById(request.getDeptSeq()).get();
        emp.setDept(dept);

        Emp result = empRepository.save(emp);
        return empMapper.toEmpResponse(result);
    }

    // 삭제
    @Transactional
    public void deleteEmp(Long empSeq) { empRepository.deleteById(empSeq); }
}
