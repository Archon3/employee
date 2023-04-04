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
    public List<DeptResponse> queryList() {
        return deptRepository.findAll()
                .stream()
                .map(DeptResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DeptResponse query(Long id) {
        //Optional
        DeptEntity result = deptRepository.findById(id)
                .orElseThrow(NullPointerException::new);

        return new DeptResponse(result);
    }

    public DeptResponse save(DeptRequest dto) {
        DeptEntity result = deptRepository.save(dto.toEntity());
        return new DeptResponse(result);
    }

    public void delete(Long id) { deptRepository.deleteById(id); }
}
