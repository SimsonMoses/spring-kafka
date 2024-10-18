package com.kafka.controller;


import com.kafka.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/message/send/all")
    public String sendAllMail(@RequestParam String message){
        mailService.sendMail(message);
        return "Mail sent to all";
    }

    @PostMapping("/message/send/category/{category}")
    public String sendMailToCategory(@RequestParam String message,@PathVariable String category){
        mailService.sendMailToSubscribe(category,message);
        return "Mail sent to all";
    }
}
