package hello.employee.controller;

import hello.employee.dto.EmpRequest;
import hello.employee.dto.EmpResponse;
import hello.employee.dto.common.ServerResponse;
import hello.employee.dto.common.SingleValueResponse;
import hello.employee.service.EmpService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "emp", description = "사원관리 API")
@RestController
@RequestMapping("/api/v1/emp")
@RequiredArgsConstructor
public class EmpController {

    private final EmpService empService;

    @GetMapping(path = "/search")
    public ServerResponse<List<EmpResponse>> getEmps() {
        return ServerResponse.of(empService.getEmps());
    }

    @GetMapping()
    public ServerResponse<EmpResponse> getEmp(
            @RequestParam Long empSeq) {
        return ServerResponse.of(empService.getEmp(empSeq));
    }

    @PostMapping()
    public ServerResponse<EmpResponse> createEmp(
            @RequestBody EmpRequest request) {
        return ServerResponse.of(empService.createEmp(request));
    }

    @PutMapping()
    public ServerResponse<EmpResponse> updateEmp(
            @RequestBody EmpRequest request) {
        return ServerResponse.of(empService.updateEmp(request));
    }

    @DeleteMapping()
    public ServerResponse<SingleValueResponse> deleteEmp(
            @RequestParam Long empSeq) {
        empService.deleteEmp(empSeq);
        return ServerResponse.of(new SingleValueResponse(true));
    }
}
