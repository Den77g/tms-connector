package com.trucker.tmsconnector.repositories;

import com.trucker.tmsconnector.entity.InboundEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<InboundEntry, Long> {
}
