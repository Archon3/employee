package hello.employee.service;

import hello.employee.entity.DeptRequest;
import hello.employee.entity.DeptEntity;
import hello.employee.entity.DeptResponse;
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

    @Transactional(readOnly = true)
    public List<DeptResponse> getDepts() {
        return deptRepository.findAll()
                .stream()
                .map(DeptResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DeptResponse getDept(Long deptSeq) {
        //Optional
        DeptEntity result = deptRepository.findById(deptSeq)
                .orElseThrow(NullPointerException::new);

        return new DeptResponse(result);
    }

    public DeptResponse createDept(DeptRequest request) {
        DeptEntity result = deptRepository.save(request.toEntity());
        return new DeptResponse(result);
    }

    public void deleteDept(Long deptSeq) { deptRepository.deleteById(deptSeq); }
}
