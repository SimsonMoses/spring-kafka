package com.kafka.service;


import com.kafka.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

    @KafkaListener(topics = AppConstants.TOPIC_NAME,
            groupId = AppConstants.GROUP_ID)
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }

    @KafkaListener(topics = "mail",
            groupId = AppConstants.GROUP_ID)
    public void consumeMail(String message){
        LOGGER.info(String.format("TOPIC : MAIL Message received -> %s", message));
    }
}
