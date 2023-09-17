package kz.alish.aster.service;

import kz.alish.aster.data.entity.Task;

import java.util.List;

public interface TaskService {
    Task create(Task task);

    List<Task> getAll();

    Task getById(Long id);

    void delete(Task task);

    List<Task> save(List<Task> tasks);
}
