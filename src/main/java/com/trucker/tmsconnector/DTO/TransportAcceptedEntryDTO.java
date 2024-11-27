package com.trucker.tmsconnector.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransportAcceptedEntryDTO {
    String scheduling_unit;
    String transport_number;
    String carrier_id;
    String currency;
    String price;

}
