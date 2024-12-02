package com.trucker.tmsconnector.controllers;

import com.trucker.tmsconnector.DTO.OrderEntryDTO;
import com.trucker.tmsconnector.entity.OrderEntry;
import com.trucker.tmsconnector.repositories.OrderEntryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@Slf4j
@RequiredArgsConstructor
@EnableScheduling
public class OrderScheduler {

    private final OrderEntryRepo orderEntryRepo;
    private final MainController mainController;

    @Scheduled(fixedRate = 600000) // Run every 10 minutes (600000 milliseconds)
    public void handleDBOrderChecker() {

        log.trace("The scheduled method are running");
        Optional<OrderEntry> orderEntryOptional = orderEntryRepo.findById(1L);
        if (orderEntryOptional.isPresent()) {
            OrderEntry orderEntry = orderEntryOptional.get();
            OrderEntryDTO orderDto = new OrderEntryDTO(orderEntry.getId(), orderEntry.getUuid(), orderEntry.getNumber(),
                    orderEntry.getNumberExt(), orderEntry.getStatus(), orderEntry.getTransportType(),
                    orderEntry.getCarrier(), orderEntry.getMarket(), orderEntry.getSchedulingUnit(),
                    orderEntry.getCountryFrom());

            // Example: Sending an order from the database via handlePostRequest
            mainController.handleOrderPostRequest(orderDto);

        }else {
            System.out.println("Order entry not found in database");
        }

    }


}
