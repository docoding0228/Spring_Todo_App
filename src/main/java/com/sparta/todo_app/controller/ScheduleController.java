package com.sparta.todo_app.controller;

import com.sparta.todo_app.dto.ScheduleRequestDto;
import com.sparta.todo_app.dto.ScheduleResponseDto;
import com.sparta.todo_app.service.ScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/spring-introduction")
@Tag(name = "Schedule Management ", description = "일정 관리 페이지 API")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules")

    public ScheduleResponseDto createSchedule(@Valid @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedules")
    public ScheduleResponseDto getSchedule(@RequestParam Long id) {
        return scheduleService.getSchedule(id);
    }

    @GetMapping("/scheduless")
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedules();
    }

    @PutMapping("/schedules")
    public ScheduleResponseDto updateSchedule(@RequestParam Long id, @Valid @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, requestDto);
    }

    @DeleteMapping("/schedules")
    public Long deleteSchedule(@RequestParam Long id, @RequestBody Map<String, String> password) {
        return scheduleService.deleteSchedule(id, password.get("password"));
    }
}
