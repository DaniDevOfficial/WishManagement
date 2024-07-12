package com.example.abschlussm223.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buchungId;

    private Date date;

    @Enumerated(EnumType.STRING)
    private RentTime rentTime;

    private Fulfilled fulfilled;

    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
