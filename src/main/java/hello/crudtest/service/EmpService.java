package hello.crudtest.service;

import hello.crudtest.entity.DeptEntity;
import hello.crudtest.entity.EmpDto;
import hello.crudtest.entity.EmpEntity;
import hello.crudtest.repository.DeptRepository;
import hello.crudtest.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmpService {

    private final EmpRepository empRepository;
    private final DeptRepository deptRepository;

    @Transactional(readOnly = true)
    public List<EmpDto> queryList() {
        return empRepository.findAll()
                .stream()
                .map(EmpDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmpDto query(Long id) {
        //Optional
        EmpEntity result = empRepository.findById(id)
                .orElseThrow(NullPointerException::new);

        return new EmpDto(result);
    }

    public EmpDto save(EmpDto dto) {

        EmpEntity emp = dto.toEntity();

        //연관관계 매핑
        DeptEntity dept = deptRepository.findById(dto.getDeptId()).get();
        emp.setDept(dept);

        EmpEntity result = empRepository.save(emp);
        return new EmpDto(result);
    }

    @Transactional
    public void delete(Long id) { empRepository.deleteById(id); }
}
