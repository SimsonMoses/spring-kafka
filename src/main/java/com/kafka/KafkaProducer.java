package com.kafka;

import com.kafka.service.KafKaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafKaConsumer kafKaConsumer;

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent -> %s", message));
        kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
        kafKaConsumer.consume(message);
    }

    public void sendMessageToTopic(String topic, String message){
        kafkaTemplate.send(topic, message);
        LOGGER.info("Topic: {} Message sent -> {}",topic, message);
    }

}