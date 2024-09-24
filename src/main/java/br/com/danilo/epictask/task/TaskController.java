package br.com.danilo.epictask.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String index(Model model) {
        var tasks = taskService.findAll();
        //dessa forma permitimos que a nossa controller passe informações para a View por meio dessa Model
        model.addAttribute("tasks", tasks);
        return "index";
    }
}
