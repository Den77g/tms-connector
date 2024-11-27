package com.trucker.tmsconnector.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingEntryDTO {
    String event;
    String current_timestamp;
    String scheduling_unit;
    String transport_number;
    String time_slot_date;
    String time_slot_time;
    String loading_gate;
    String driver_name;
    String licence_plate;
    String driver_phone;
    String comment;

}
