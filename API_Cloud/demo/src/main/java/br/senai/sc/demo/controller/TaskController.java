package br.senai.sc.demo.controller;

import br.senai.sc.demo.Service.TaskService;
import br.senai.sc.demo.controller.dto.TaskPostDTO;
import br.senai.sc.demo.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public void cadastrarTask(@RequestBody TaskPostDTO taskPostDTO){
        taskService.criarTask(taskPostDTO);
    }

    @GetMapping("/{id}")
    public Task buscarTask(@PathVariable Integer id){
        return taskService.buscarTaskPorId(id);
    }
}
