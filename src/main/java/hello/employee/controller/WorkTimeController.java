package hello.employee.controller;

import hello.employee.dto.WorkTimeQueryResponse;
import hello.employee.service.WorkTimeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "workTime", description = "출퇴근내역조회 API")
@RestController
@RequestMapping("/api/vi/workTime")
@RequiredArgsConstructor
public class WorkTimeController {

    private final WorkTimeService workTimeService;

    @GetMapping()
    public List<WorkTimeQueryResponse> getWorkTimeByName(
            @RequestParam String empName,
            @RequestParam String begDate,
            @RequestParam String endDate) {
        return workTimeService.getWorkTimeByName(empName, begDate, endDate);
    }

}
