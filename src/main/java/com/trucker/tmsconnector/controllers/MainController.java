package com.trucker.tmsconnector.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trucker.tmsconnector.entity.InboundEntry;
import com.trucker.tmsconnector.repositories.EntryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    private final ObjectMapper objectMapper;
    private final EntryRepository entryRepository;

    @PostMapping("/api/add")
    public void addEntry(@RequestBody InboundEntry inboundEntry){
        log.info("New row: " + entryRepository.save(inboundEntry));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public String getAll(){
        List<InboundEntry> inboundEntryList = entryRepository.findAll();
        return objectMapper.writeValueAsString(inboundEntryList);
    }











    @GetMapping("/api/main")
    public String mainListener(){
        return "Hello world";
    }

    @GetMapping("/api/entry")
    public String giveEntry(){
        InboundEntry inboundEntry = new InboundEntry("Value 1", "Name 1");
        String jsonData = "no data";

        try {
            jsonData = objectMapper.writeValueAsString(inboundEntry);
        }catch (JsonProcessingException e){
            System.out.println("Error of inbound entry");
        }

        return jsonData;
    }

    @PostMapping("/api/special")
    public String giveSpacialEntry(@RequestParam String value){
        InboundEntry inboundEntry = new InboundEntry(value, "Name 1");
        String jsonData = "no data";

        try {
            jsonData = objectMapper.writeValueAsString(inboundEntry);
        }catch (JsonProcessingException e){
            System.out.println("Error of inbound entry");
        }

        return jsonData;
    }
}
