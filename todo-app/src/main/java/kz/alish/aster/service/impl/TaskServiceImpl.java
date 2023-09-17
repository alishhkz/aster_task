package kz.alish.aster.service.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.alish.aster.data.entity.Task;
import kz.alish.aster.data.repository.TaskRepository;
import kz.alish.aster.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public List<Task> save(List<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }

}
