package hello.crudtest.controller;

import hello.crudtest.entity.DeptDto;
import hello.crudtest.service.DeptService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "dept", description = "부서관리 API")
@RestController
@RequestMapping("/dept")
@RequiredArgsConstructor
public class DeptController {

    private final DeptService deptService;

    @GetMapping()
    public List<DeptDto> queryList() { return deptService.queryList(); }

    @GetMapping(path = "/{id}")
    public DeptDto query(@PathVariable(value ="id") Long id) { return deptService.query(id); }

    @PostMapping()
    public DeptDto save(@RequestBody DeptDto requestDto) {
        return deptService.save(requestDto);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable(value ="id") Long id) {
        deptService.delete(id);
        return "success";
    }
}
