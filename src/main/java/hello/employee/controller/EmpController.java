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
    public List<EmpResponse> queryList() { return empService.queryList(); }

    @GetMapping(path = "/{id}")
    public EmpResponse query(@PathVariable(value ="id") Long id) { return empService.query(id); }

    @PostMapping()
    public EmpResponse save(@RequestBody EmpRequest requestDto) {
        return empService.save(requestDto);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable(value ="id") Long id) {
        empService.delete(id);
        return "success";
    }
}
