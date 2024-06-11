package com.trucker.tmsconnector.controllers;

import com.trucker.tmsconnector.kafka.KafkaProducer;
import com.trucker.tmsconnector.repositories.EntryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final KafkaProducer kafkaProducer;

    private final EntryRepository entryRepository;

    /*public Controller(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }*/

    public Controller(KafkaProducer kafkaProducer, EntryRepository entryRepository) {
        this.kafkaProducer = kafkaProducer;
        this.entryRepository = entryRepository;
    }

    @PostMapping("/kafka/send")
    public String send(@RequestParam long id){
        /*entryRepository.findById(id).toString();*/
        kafkaProducer.sendMessage(entryRepository.findById(id).toString());

        return "Success";
    }

}
