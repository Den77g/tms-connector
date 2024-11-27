package com.trucker.tmsconnector.repositories;


import com.trucker.tmsconnector.entity.BookingEntry;
import com.trucker.tmsconnector.entity.TransportAcceptedEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingEntryRepo extends JpaRepository<BookingEntry, Long> {



}
