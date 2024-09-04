package br.senai.sc.demo.service.kafka;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
@EnableKafka
public class ConsumerService {

    private KafkaConsumer<String, String> kafkaConsumer;

    public HashSet<String> getAllMessages(){
        kafkaConsumer.subscribe(Collections.singletonList("my-topic"));
        HashSet<String> messages = new HashSet<>();
        ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
        for (ConsumerRecord<String, String> record : records) {
            messages.add(record.value());
        }
        return messages;
    }

}
