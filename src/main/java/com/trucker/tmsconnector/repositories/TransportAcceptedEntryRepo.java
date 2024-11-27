package com.trucker.tmsconnector.repositories;


import com.trucker.tmsconnector.entity.FirstInboundEntry;
import com.trucker.tmsconnector.entity.TransportAcceptedEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransportAcceptedEntryRepo extends JpaRepository<TransportAcceptedEntry, Long> {

    //TransportAcceptedEntryRepo findByName(String name);

}
