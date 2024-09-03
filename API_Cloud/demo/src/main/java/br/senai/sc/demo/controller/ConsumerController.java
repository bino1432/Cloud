package br.senai.sc.demo.controller;

import br.senai.sc.demo.service.kafka.ConsumerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/kafka")
public class ConsumerController {

    private ConsumerService consumerService;

    @GetMapping
    public List<String> getAllMessages() {
        return consumerService.getAllMessages();
    }
}
