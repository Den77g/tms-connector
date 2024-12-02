package com.trucker.tmsconnector.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntryDTO {

    private long id;
    private String uuid;
    private String number;
    private String numberExt;
    private String status;
    private String transportType;
    private String carrier;
    private String market;
    private String schedulingUnit;
    private String countryFrom;
}
