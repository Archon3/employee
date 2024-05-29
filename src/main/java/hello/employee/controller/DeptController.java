package hello.employee.controller;

import hello.employee.dto.DeptRequest;
import hello.employee.dto.DeptResponse;
import hello.employee.dto.common.ServerResponse;
import hello.employee.dto.common.SingleValueResponse;
import hello.employee.service.DeptService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "dept", description = "부서관리 API")
@RestController
@RequestMapping("/api/v1/dept")
@RequiredArgsConstructor
public class DeptController {

    private final DeptService deptService;

    @GetMapping(path = "/search")
    public ServerResponse<List<DeptResponse>> getDepts() {
        return ServerResponse.of(deptService.getDepts());
    }

    @GetMapping()
    public ServerResponse<DeptResponse> getDept(
            @RequestParam Long deptSeq) {
        return ServerResponse.of(deptService.getDept(deptSeq));
    }

    @PostMapping()
    public ServerResponse<DeptResponse> createDept(
            @RequestBody DeptRequest request) {
        return ServerResponse.of(deptService.createDept(request));
    }

    @PutMapping()
    public ServerResponse<DeptResponse> updateDept(
            @RequestBody DeptRequest request) {
        return ServerResponse.of(deptService.updateDept(request));
    }

    @DeleteMapping()
    public ServerResponse<SingleValueResponse> deleteDept(
            @RequestParam Long deptSeq) {
        deptService.deleteDept(deptSeq);
        return ServerResponse.of(new SingleValueResponse(true));
    }
}
