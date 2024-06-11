package com.trucker.tmsconnector.controllers;

import com.trucker.tmsconnector.entity.FirstInboundEntry;
import com.trucker.tmsconnector.repositories.FirstInboundEntryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/first")
@RequiredArgsConstructor
public class FirstInboundEntryController {
    private final FirstInboundEntryRepo firstInboundEntryRepo;

    @GetMapping("/all")
    public List<FirstInboundEntry> getAllFirstInboundEntries() {
        return firstInboundEntryRepo.findAll();
    }

    @GetMapping
    public ResponseEntity<FirstInboundEntry> getFirstByName(@RequestParam String name) {
        var firstInEntry = firstInboundEntryRepo.findByName(name);

        if (firstInEntry == null){
                return ResponseEntity
                        .status(HttpStatusCode.valueOf(404))
                        .build();
        }

        return new ResponseEntity<>(firstInEntry, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public FirstInboundEntry putFirstInboundEntry(@RequestBody FirstInboundEntry firstInEntry) {
        firstInEntry.setId(UUID.randomUUID());
        return firstInboundEntryRepo.save(firstInEntry);
    }

}
