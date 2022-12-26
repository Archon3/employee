package hello.crudtest.controller;

import hello.crudtest.entity.EmpDto;
import hello.crudtest.service.EmpService;
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
    public List<EmpDto> queryList() { return empService.queryList(); }

    @GetMapping(path = "/{id}")
    public EmpDto query(@PathVariable(value ="id") Long id) { return empService.query(id); }

    @PostMapping()
    public EmpDto save(@RequestBody EmpDto requestDto) {
        return empService.save(requestDto);
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable(value ="id") Long id) {
        empService.delete(id);
        return "success";
    }
}
