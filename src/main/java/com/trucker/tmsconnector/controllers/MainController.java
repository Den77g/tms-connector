package com.trucker.tmsconnector.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trucker.tmsconnector.DTO.BookingEntryDTO;
import com.trucker.tmsconnector.DTO.EntryDTO;
import com.trucker.tmsconnector.DTO.OrderEntryDTO;
import com.trucker.tmsconnector.DTO.TransportAcceptedEntryDTO;
import com.trucker.tmsconnector.entity.BookingEntry;
import com.trucker.tmsconnector.entity.InboundEntry;
import com.trucker.tmsconnector.entity.OrderEntry;
import com.trucker.tmsconnector.entity.TransportAcceptedEntry;
import com.trucker.tmsconnector.repositories.BookingEntryRepo;
import com.trucker.tmsconnector.repositories.EntryRepository;
import com.trucker.tmsconnector.repositories.OrderEntryRepo;
import com.trucker.tmsconnector.repositories.TransportAcceptedEntryRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Tag(name = "main_methods")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    private final EntryRepository entryRepository;
    private final TransportAcceptedEntryRepo transportAcceptedEntryRepo;

    private final BookingEntryRepo bookingEntryRepo;



    @PostMapping("/order")
    public String handleOrderPostRequest(@RequestBody OrderEntryDTO order) {

        String url = "https://integration.app/tms_customer_configuration/v1";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<OrderEntryDTO> request = new HttpEntity<>(order, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        System.out.println("Response from external API: " + response.getBody());
        return "Order processed successfully with response: " + response.getBody();
    }



    @Operation(
            summary = "Add new transport accepted entry to DB",
            description = "Get a new transport accepted DTO entry object and builder collect and insert it to DB"
    )
    @PostMapping("/api/v1/add_transport_accepted")
    public void addTransportAcceptedEntry(@RequestBody TransportAcceptedEntryDTO transportAcceptedEntryDTO){
        log.info("New TA_row: " + transportAcceptedEntryRepo.save(
                TransportAcceptedEntry.builder()
                        .scheduling_unit(transportAcceptedEntryDTO.getScheduling_unit())
                        .transport_number(transportAcceptedEntryDTO.getTransport_number())
                        .carrier_id(transportAcceptedEntryDTO.getCarrier_id())
                        .price(transportAcceptedEntryDTO.getPrice())
                        .currency(transportAcceptedEntryDTO.getCurrency())
                        .build()));
    }

    @PostMapping("/api/v1/add_booking_event")
    public void addTransportEvent(@RequestBody BookingEntryDTO bookingEntryDTO){
        log.info("New Transport Event: " + bookingEntryRepo.save(
                BookingEntry.builder()
                        .event(bookingEntryDTO.getEvent())
                        .currentTimestampValue(bookingEntryDTO.getCurrent_timestamp())
                        .schedulingUnit(bookingEntryDTO.getScheduling_unit())
                        .transportNumber(bookingEntryDTO.getTransport_number())
                        .timeSlotDate(bookingEntryDTO.getTime_slot_date())
                        .timeSlotTime(bookingEntryDTO.getTime_slot_time())
                        .loadingGate(bookingEntryDTO.getLoading_gate())
                        .driverName(bookingEntryDTO.getDriver_name())
                        .licencePlate(bookingEntryDTO.getLicence_plate())
                        .driverPhone(bookingEntryDTO.getDriver_phone())
                        .comment(bookingEntryDTO.getComment())
                        .build()
        ));
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
}
