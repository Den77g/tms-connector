package com.trucker.tmsconnector.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "entries")
public class InboundEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String value;

    public InboundEntry(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public InboundEntry() {
    }

    @Override
    public String toString() {
        return "InboundEntry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
