package com.example.demo.service;

import com.example.demo.dto.TaskDto;
import com.example.demo.dto.request.TaskRequest;

import java.util.List;

public interface TaskService {
    List<TaskDto> getTaskByUser(String email);

    List<TaskDto> getTasksWithoutCategory(String email);

    List<TaskDto> getTaskByCategoryId(Long categoryId, String email);

    TaskDto createTask(TaskRequest request, String email);

    TaskDto getTaskById(Long id, String email);

    TaskDto updateById(Long id, TaskRequest task, String email);

    void deleteById(Long id, String email);
}
