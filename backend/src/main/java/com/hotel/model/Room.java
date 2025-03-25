package com.hotel.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String type;

    private Long price;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean available;

}
