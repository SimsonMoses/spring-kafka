package com.kafka.service;

import com.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService { // producer might be changing

    @Autowired
    private KafkaProducer kafkaProducer;

    public String sendMessage(String message){
        kafkaProducer.sendMessage(message);
        return "Message sent to kafka topic";
    }

    public String sendMessageToTopic(String topic, String message){
        kafkaProducer.sendMessageToTopic(topic, message);
        return "Message sent to kafka topic";
    }
}
