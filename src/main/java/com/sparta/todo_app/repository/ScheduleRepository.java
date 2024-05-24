package com.sparta.todo_app.repository;

import com.sparta.todo_app.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {}
