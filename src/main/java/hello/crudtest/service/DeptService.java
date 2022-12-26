package hello.crudtest.service;

import hello.crudtest.entity.DeptDto;
import hello.crudtest.entity.DeptEntity;
import hello.crudtest.entity.EmpDto;
import hello.crudtest.entity.EmpEntity;
import hello.crudtest.repository.DeptRepository;
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
    public List<DeptDto> queryList() {
        return deptRepository.findAll()
                .stream()
                .map(DeptDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DeptDto query(Long id) {
        //Optional
        DeptEntity result = deptRepository.findById(id)
                .orElseThrow(NullPointerException::new);

        return new DeptDto(result);
    }

    public DeptDto save(DeptDto dto) {
        DeptEntity result = deptRepository.save(dto.toEntity());
        return new DeptDto(result);
    }

    public void delete(Long id) { deptRepository.deleteById(id); }
}
