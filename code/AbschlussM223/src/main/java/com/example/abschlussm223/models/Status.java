package com.example.abschlussm223.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    private boolean paid;

    @Enumerated(EnumType.STRING)
    private Fulfilled fulfilled;



    public Status(boolean paid, Fulfilled fulfilled) {
        this.paid = paid;
        this.fulfilled = fulfilled;
    }
}
