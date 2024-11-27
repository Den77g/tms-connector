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
@Table(name = "entry_transport_accepted")
public class TransportAcceptedEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scheduling_unit")
    private String scheduling_unit;

    @Column(name = "transport_number")
    private String transport_number;

    @Column(name = "carrier_id")
    private String carrier_id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "price")
    private String price;


    @Override
    public String toString() {
        return "TransportAcceptedEntry{" +
                "id=" + id +
                ", scheduling_unit='" + scheduling_unit + '\'' +
                ", transport_number='" + transport_number + '\'' +
                ", carrier_id='" + carrier_id + '\'' +
                ", currency='" + currency + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
