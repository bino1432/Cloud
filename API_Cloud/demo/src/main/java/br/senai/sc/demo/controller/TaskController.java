package br.senai.sc.demo.controller;

import br.senai.sc.demo.Service.TaskService;
import br.senai.sc.demo.controller.dto.TaskPostDTO;
import br.senai.sc.demo.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
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
}
