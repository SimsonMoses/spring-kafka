package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private MessageProducerService messageProducerService;

    public String sendMail(String message){ // to all
        return messageProducerService.sendMessage(message);
    }

    public String sendMailToSubscribe(String category, String message){ // to specific topic
        // we will not get the topic as parameter from the user, we will only categorize the message and send it to the appropriate topic
        String topic = "mail";
        return messageProducerService.sendMessageToTopic(topic, message);
    }

    // set the smtp server and send the mail as the async task


}
