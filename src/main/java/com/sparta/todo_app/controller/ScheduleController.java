package com.sparta.todo_app.controller;

import com.sparta.todo_app.dto.ScheduleRequestDto;
import com.sparta.todo_app.dto.ScheduleResponseDto;
import com.sparta.todo_app.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/sprig-introduction")
@Tag(name = "Schedule Management ", description = "일정 관리 페이지 API")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedule")
    @Operation(summary = "일정 작성")

    public ScheduleResponseDto createSchedule(@Valid @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedule")
    @Operation(summary = "선택한 일정 조회")
    public ScheduleResponseDto getSchedule(@RequestParam Long id) {
        return scheduleService.getSchedule(id);
    }

    @GetMapping("/schedules")
    @Operation(summary = "일정 목록 조회")
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedules();
    }

    @PutMapping("/schedule")
    @Operation(summary = "선택한 일정 수정")

    public ScheduleResponseDto updateSchedule(@RequestParam Long id, @Valid @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, requestDto);
    }

    @DeleteMapping("/schedule")
    @Operation(summary = "선택한 일정 삭제")

    public Long deleteSchedule(@RequestParam Long id, @RequestBody Map<String, String> password) {
        return scheduleService.deleteSchedule(id, password.get("password"));
    }
}
