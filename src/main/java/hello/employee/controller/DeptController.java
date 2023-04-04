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
    public List<DeptResponse> getDepts() { return deptService.getDepts(); }

    @GetMapping(path = "/{deptSeq}")
    public DeptResponse getDept(@PathVariable(value ="deptSeq") Long deptSeq) { return deptService.getDept(deptSeq); }

    @PostMapping()
    public DeptResponse createDept(@RequestBody DeptRequest request) {
        return deptService.createDept(request);
    }

    @DeleteMapping(path = "/{deptSeq}")
    public String deleteDept(@PathVariable(value ="deptSeq") Long deptSeq) {
        deptService.deleteDept(deptSeq);
        return "success";
    }
}
