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
@Table(name = "entry_execution_made")
public class InboundEntryExecutionMade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String event_slug;
    @Column
    private String reference_number;
    @Column
    private String executor_external_number;
    @Column
    private double cost;
    @Column
    private String vat_rate;
    @Column
    private String unit;
    @Column
    private String currency;
    @Column
    private String lookup_method_type;
    @Column
    private boolean distributed_by_quota;
    @Column
    private String contract_name;


    @Override
    public String toString() {
        return "InboundEntryExecutionMade{" +
                "id=" + id +
                ", event_slug='" + event_slug + '\'' +
                ", reference_number='" + reference_number + '\'' +
                ", executor_external_number='" + executor_external_number + '\'' +
                ", cost=" + cost +
                ", vat_rate='" + vat_rate + '\'' +
                ", unit='" + unit + '\'' +
                ", currency='" + currency + '\'' +
                ", lookup_method_type='" + lookup_method_type + '\'' +
                ", distributed_by_quota=" + distributed_by_quota +
                ", contract_name='" + contract_name + '\'' +
                '}';
    }
}
