package com.trucker.tmsconnector.repositories;


import com.trucker.tmsconnector.entity.FirstInboundEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FirstInboundEntryRepo extends MongoRepository<FirstInboundEntry, UUID> {

    FirstInboundEntry findByName(String name);

}
