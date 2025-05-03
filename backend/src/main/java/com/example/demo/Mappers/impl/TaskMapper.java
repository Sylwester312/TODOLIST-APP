package com.example.demo.Mappers.impl;

import com.example.demo.Mappers.Mapper;
import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Task;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TaskMapper implements Mapper<Task, TaskDto> {

    private ModelMapper modelMapper;

    @Override
    public TaskDto mapTo(Task taskEntity) {
        return modelMapper.map(taskEntity, TaskDto.class);
    }

    @Override
    public Task mapFrom(TaskDto taskDto) {
        return modelMapper.map(taskDto, Task.class);
    }
}
