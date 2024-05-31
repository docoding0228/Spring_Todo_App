package com.sparta.todo_app.controller;

import com.sparta.todo_app.dto.ScheduleRequestDto;
import com.sparta.todo_app.dto.ScheduleResponseDto;
import com.sparta.todo_app.service.ScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring-introduction")
@Tag(name = "Schedule Management ", description = "일정 관리 페이지 API")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // @RequestPart 10단계
    // @RequestParam ? 방식
    // @RequestBody
    // @PathVariable /1
    // InvalidContentTypeException
    // 매개변수, Dto, 엔티티, 요청받는방식
    // JPA, @Entity, 엔드포인트

    /**
     * 일정 작성
     */
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@Valid @RequestBody ScheduleRequestDto requestDto)
    { return ResponseEntity.ok(scheduleService.createSchedule(requestDto)); }

    /**
     * 선택한 일정 조회
     */
    @GetMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> getSchedule(@RequestParam Long id) {
        return ResponseEntity.ok(scheduleService.getSchedule(id));
    }

    /**
     * 전체 일정 목록 조회
     */
    @GetMapping("/scheduless")
    public ResponseEntity<List<ScheduleResponseDto>> getSchedules() {
        return ResponseEntity.ok(scheduleService.getSchedules());
    }

    /**
     * 일정 수정
     */
    // PathVariable schedules/{id}
    // RequestParam /schedules
    @PutMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@RequestParam Long id, @Valid @RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto updatedSchedule = scheduleService.updateSchedule(id, requestDto);
        return ResponseEntity.ok(updatedSchedule);
    }

//    @DeleteMapping("/schedules")
//    public Long deleteSchedule(@RequestParam Long id, @RequestBody Map<String, String> password) {
//        return scheduleService.deleteSchedule(id, password.get("password"));
//    }
    /**
     * 일정 삭제
     */
    @DeleteMapping("/schedules")
    public Long deleteSchedule(@RequestParam Long id) {
        return scheduleService.deleteSchedule(id);
    }
}



