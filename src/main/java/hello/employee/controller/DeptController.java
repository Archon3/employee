package hello.employee.controller;

import hello.employee.entity.DeptRequest;
import hello.employee.entity.DeptResponse;
import hello.employee.service.DeptService;
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
    public List<DeptResponse> queryList() { return deptService.queryList(); }

    @GetMapping(path = "/{id}")
    public DeptResponse query(@PathVariable(value ="id") Long id) { return deptService.query(id); }

    @PostMapping()
    public DeptResponse save(@RequestBody DeptRequest requestDto) {
        return deptService.save(requestDto);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable(value ="id") Long id) {
        deptService.delete(id);
        return "success";
    }
}
