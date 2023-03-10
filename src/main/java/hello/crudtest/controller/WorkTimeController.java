package hello.crudtest.controller;

import hello.crudtest.entity.WorkTimeQueryDto;
import hello.crudtest.service.WorkTimeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "workTime", description = "출퇴근내역조회 API")
@RestController
@RequestMapping("/workTime")
@RequiredArgsConstructor
public class WorkTimeController {

    private final WorkTimeService workTimeService;

    @GetMapping(path = "/{empName}")
    public List<WorkTimeQueryDto> queryByName(@PathVariable String empName,
                                              @RequestParam String begDate,
                                              @RequestParam String endDate) {
        return workTimeService.queryByName(empName, begDate, endDate);
    }

}
