package br.senai.sc.demo.controller;

import br.senai.sc.demo.Service.TaskService;
import br.senai.sc.demo.controller.dto.TaskPostDTO;
import br.senai.sc.demo.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/aws")
public class TaskController {

    private TaskService service;

    @PostMapping("/task")
    public String cadastrarTask(@RequestBody TaskPostDTO taskPostDTO){
        service.criarTask(taskPostDTO);
        return "Task " + taskPostDTO.nome() + " criada com sucesso";
    }

    @GetMapping("/task/{id}")
    public Task buscarTask(@PathVariable Integer id){
        return service.buscarTaskPorId(id);
    }

    @GetMapping("/task")
    public List<Task> buscarTodasTasks(){
        return service.buscarTodasTasks();
    }

    @GetMapping("/{id}")
    public List<String> buscarImagens(@PathVariable Integer id){
        return service.buscarImagens(id);
    }
}
