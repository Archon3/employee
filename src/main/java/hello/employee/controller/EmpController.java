package hello.employee.controller;

import hello.employee.entity.EmpRequest;
import hello.employee.entity.EmpResponse;
import hello.employee.service.EmpService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "emp", description = "사원관리 API")
@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmpController {

    private final EmpService empService;

    @GetMapping()
    public List<EmpResponse> getEmps() { return empService.getEmps(); }

    @GetMapping(path = "/{empSeq}")
    public EmpResponse getEmp(@PathVariable(value ="empSeq") Long empSeq) { return empService.getEmp(empSeq); }

    @PostMapping()
    public EmpResponse createEmp(@RequestBody EmpRequest requestDto) {
        return empService.createEmp(requestDto);
    }

    @DeleteMapping(path = "/{empSeq}")
    public String deleteEmp(@PathVariable(value ="empSeq") Long empSeq) {
        empService.deleteEmp(empSeq);
        return "success";
    }
}
