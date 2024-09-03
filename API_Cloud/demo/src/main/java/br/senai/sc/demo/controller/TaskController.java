package br.senai.sc.demo.controller;

import br.senai.sc.demo.service.TaskService;
import br.senai.sc.demo.controller.dto.TaskPostDTO;
import br.senai.sc.demo.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/aws/task")
public class TaskController {

    private TaskService service;

    @PostMapping
    public String cadastrarTask(@RequestBody TaskPostDTO taskPostDTO){
        service.criarTask(taskPostDTO);
        return "Task " + taskPostDTO.nome() + " criada com sucesso";
    }

    @GetMapping("/{id}")
    public Task buscarTask(@PathVariable Integer id){
        return service.buscarTaskPorId(id);
    }

    @GetMapping
    public List<Task> buscarTodasTasks(){
        return service.buscarTodasTasks();
    }

}
