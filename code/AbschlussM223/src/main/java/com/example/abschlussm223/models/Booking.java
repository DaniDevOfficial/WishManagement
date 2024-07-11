package com.example.abschlussm223.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buchungId;

    private Date datum;

    @Enumerated(EnumType.STRING)
    private RentTime mietZeit;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
