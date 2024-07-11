package com.example.abschlussm223.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    private boolean bezahlt;

    @Enumerated(EnumType.STRING)
    private Fulfilled erfüllung;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
    }

    public Fulfilled getErfüllung() {
        return erfüllung;
    }

    public void setErfüllung(Fulfilled erfüllung) {
        this.erfüllung = erfüllung;
    }
}
