package kz.alish.aster.controller;

import kz.alish.aster.data.entity.Task;
import kz.alish.aster.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        return "index";
    }

    @PostMapping(value = "/create")
    public String create(Task task) {
        taskService.create(task);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getById(id));
        return "details";
    }

    @PostMapping(value = "/update")
    public String update() {

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        taskService.delete(taskService.getById(id));
        return "redirect:/";
    }
}
