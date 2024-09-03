package br.senai.sc.demo.service.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ConsumerService {

    List<String> messages;

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listenGroup(String message) {
        synchronized (messages){
            messages.add(message);
        }
        System.out.println("Mensagem Recebida: " + message);
    }

    public List<String> getAllMessages() {
        synchronized (messages) {
            return new ArrayList<>(messages);
        }
    }

}
