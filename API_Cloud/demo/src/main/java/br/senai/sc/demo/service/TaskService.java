package br.senai.sc.demo.service;

import br.senai.sc.demo.service.kafka.ProducerService;
import br.senai.sc.demo.controller.dto.TaskPostDTO;
import br.senai.sc.demo.model.Task;
import br.senai.sc.demo.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;
    private FileService fileService;
    private ProducerService producerService;

    public TaskPostDTO criarTask(TaskPostDTO taskPostDTO) {
        Task task = new Task();
        task.setNome(taskPostDTO.nome());

        producerService.sendMessage("Task criada: " + taskPostDTO.nome());
        taskRepository.save(task);
        return taskPostDTO;
    }

    public Task buscarTaskPorId(Integer id) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        producerService.sendMessage("Task buscada com id: " + id);
        Task task = taskOptional.get();
        return task;
    }

    public List<Task> buscarTodasTasks(){
        producerService.sendMessage("Todas as tasks buscadas");
        return taskRepository.findAll();
    }
}
