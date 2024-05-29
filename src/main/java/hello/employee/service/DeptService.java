package hello.employee.service;

import hello.employee.dto.DeptRequest;
import hello.employee.entity.Dept;
import hello.employee.dto.DeptResponse;
import hello.employee.mapper.DeptMapper;
import hello.employee.repository.DeptRepository;
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
public class DeptService {

    private final DeptRepository deptRepository;
    private final DeptMapper deptMapper;

    @Transactional(readOnly = true)
    public List<DeptResponse> getDepts() {
        return deptMapper.toDeptResponseList(deptRepository.findAll());
    }

    @Transactional(readOnly = true)
    public DeptResponse getDept(Long deptSeq) {
        //Optional
        Dept result = deptRepository.findById(deptSeq)
                .orElseThrow(NullPointerException::new);

        return deptMapper.toDeptResponse(result);
    }

    public DeptResponse createDept(DeptRequest request) {
        Dept dept = deptMapper.toDeptCreate(request);
        Dept result = deptRepository.save(dept);
        return deptMapper.toDeptResponse(result);
    }

    public DeptResponse updateDept(DeptRequest request) {
        Dept dept = deptMapper.toDept(request);
        Dept result = deptRepository.save(dept);
        return deptMapper.toDeptResponse(result);
    }

    public void deleteDept(Long deptSeq) { deptRepository.deleteById(deptSeq); }
}
