package br.senai.sc.demo.controller.dto;

import br.senai.sc.demo.model.Task;
import br.senai.sc.demo.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskPostDTO {
    private String nome;
}
