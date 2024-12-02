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
@Table(name = "entry_order")
public class OrderEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "uuid")
    private String uuid;

    @Column(nullable = false, name = "number")
    private String number;

    @Column(nullable = false, name = "number_ext")
    private String numberExt;

    @Column(nullable = false, name = "status")
    private String status;

    @Column(name = "transport_type")
    private String transportType;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "market")
    private String market;

    @Column(name = "scheduling_unit")
    private String schedulingUnit;

    @Column(name = "country_from")
    private String countryFrom;

}
