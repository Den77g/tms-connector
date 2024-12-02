package com.trucker.tmsconnector.repositories;

import com.trucker.tmsconnector.entity.OrderEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntryRepo extends JpaRepository<OrderEntry, Long> {
}
