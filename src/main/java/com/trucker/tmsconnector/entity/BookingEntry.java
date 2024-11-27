package com.trucker.tmsconnector.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entry_booking")
public class BookingEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event")
    private String event = "TSUN";

    @Column(name = "current_timestamp_value")
    private String currentTimestampValue;

    @Column(name = "scheduling_unit")
    private String schedulingUnit;

    @Column(name = "transport_number")
    private String transportNumber;

    @Column(name = "time_slot_date")
    private String timeSlotDate;

    @Column(name = "time_slot_time")
    private String timeSlotTime;

    @Column(name = "loading_gate")
    private String loadingGate;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "driver_phone")
    private String driverPhone;

    @Column(name = "comment")
    private String comment;

    @Override
    public String toString() {
        return "BookingEntry{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", currentTimestamp='" + currentTimestampValue + '\'' +
                ", schedulingUnit='" + schedulingUnit + '\'' +
                ", transportNumber='" + transportNumber + '\'' +
                ", timeSlotDate='" + timeSlotDate + '\'' +
                ", timeSlotTime='" + timeSlotTime + '\'' +
                ", loadingGate='" + loadingGate + '\'' +
                ", driverName='" + driverName + '\'' +
                ", licencePlate='" + licencePlate + '\'' +
                ", driverPhone='" + driverPhone + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

/*@Override
    public String toString() {
        return "TransportAcceptedEntry{" +
                "id=" + id +
                ", scheduling_unit='" + scheduling_unit + '\'' +
                ", transport_number='" + transport_number + '\'' +
                ", carrier_id='" + carrier_id + '\'' +
                ", currency='" + currency + '\'' +
                ", price='" + price + '\'' +
                '}';
    }*/
}
