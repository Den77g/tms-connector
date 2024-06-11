package com.trucker.tmsconnector.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trucker.tmsconnector.DTO.EntryDTO;
import com.trucker.tmsconnector.entity.InboundEntry;
import com.trucker.tmsconnector.repositories.EntryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "main_methods")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    private final ObjectMapper objectMapper;
    private final EntryRepository entryRepository;

    @Operation(
            summary = "Add new entry to DB",
            description = "Get a new DTO entry object and builder collect and insert it to DB"
    )
    @PostMapping("/api/add")
    public void addEntry(@RequestBody EntryDTO entryDTO){
        log.info("New row: " + entryRepository.save(
                InboundEntry.builder()
                        .id(7L)
                        .name(entryDTO.getName())
                        .value(entryDTO.getValue())
                        .build()));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<InboundEntry> getAll(){
        return entryRepository.findAll();
    }

    @GetMapping("/api/")
    public InboundEntry getEntry(@RequestParam Long id){
        return entryRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/api/")
    public void deleteEntry(@RequestParam Long id){
        entryRepository.deleteById(id);
    }

    @PutMapping("/api/add")
    public String changeEntry(@RequestParam InboundEntry inboundEntry){
        if (!entryRepository.existsById(inboundEntry.getId())){
            return "No such row";
        }
        return entryRepository.save(inboundEntry).toString();
    }









/*

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
    }*/
}
