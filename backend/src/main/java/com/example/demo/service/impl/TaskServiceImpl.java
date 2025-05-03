package com.example.demo.service.impl;

import com.example.demo.Mappers.Mapper;
import com.example.demo.Mappers.impl.TaskMapper;
import com.example.demo.dto.TaskDto;
import com.example.demo.dto.request.TaskRequest;
import com.example.demo.entity.Category;
import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.handler.BusinessErrorCodes;
import com.example.demo.handler.CustomException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final TaskMapper mapper;

    @Override
    public List<TaskDto> getTaskByUser(String email) {
        User user = getCurrentUser(email);
        return taskRepository.findByUser(user).stream().map(mapper::mapTo).collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getTasksWithoutCategory(String email) {
        User user = getCurrentUser(email);
        return taskRepository.findByUser(user).stream().filter(t -> t.getCategory() == null).map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getTaskByCategoryId(Long categoryId, String email) {
        User user = getCurrentUser(email);
        Category category = getCategoryById(categoryId);

        if (!category.getUser().getEmail().equals(user.getEmail())) {
            throw new CustomException(BusinessErrorCodes.ACCESS_DENIED);
        }

        return taskRepository.findByCategory(category)
                .stream()
                .map(mapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto createTask(TaskRequest request, String email) {
        User user = getCurrentUser(email);
        Category categoryEntity = null;
        if (request.getCategoryId() != null) {
            categoryEntity = getCategoryById(request.getCategoryId());

            if (!categoryEntity.getUser().getEmail().equals(user.getEmail())) {
                throw new CustomException(BusinessErrorCodes.ACCESS_DENIED);
            }
        }
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .category(categoryEntity)
                .status(request.getStatus())
                .user(user)
                .build();
        Task savedTask = taskRepository.save(task);
        return mapper.mapTo(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long id, String email) {
        User user = getCurrentUser(email);
        Task task = getTaskById(id);

        if (!task.getUser().getEmail().equals(user.getEmail())) {
            throw new CustomException(BusinessErrorCodes.ACCESS_DENIED);
        }

        return mapper.mapTo(task);
    }

    @Override
    public TaskDto updateById(Long id, TaskRequest request, String email) {
        User user = getCurrentUser(email);
        Task task = getTaskById(id);

        if (!task.getUser().getEmail().equals(user.getEmail())) {
            throw new CustomException(BusinessErrorCodes.ACCESS_DENIED);
        }

        Category categoryEntity = null;
        if (request.getCategoryId() != null) {
            categoryEntity = getCategoryById(request.getCategoryId());
            if (!categoryEntity.getUser().getEmail().equals(user.getEmail())) {
                throw new CustomException(BusinessErrorCodes.ACCESS_DENIED);
            }
        }

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setCategory(categoryEntity);
        Task saved = taskRepository.save(task);
        return mapper.mapTo(saved);
    }

    @Override
    public void deleteById(Long id, String email) {
        User user = getCurrentUser(email);
        Task task = getTaskById(id);

        if (!task.getUser().getEmail().equals(user.getEmail())) {
            throw new CustomException(BusinessErrorCodes.ACCESS_DENIED);
        }

        taskRepository.deleteById(id);
    }

    private User getCurrentUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(BusinessErrorCodes.NO_SUCH_EMAIL));
    }

    private Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CustomException(BusinessErrorCodes.NO_SUCH_CATEGORY));
    }

    private Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new CustomException(BusinessErrorCodes.NO_SUCH_TASK));
    }
}
