package com.example.abschlussm223.models;


import jakarta.persistence.*;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    private boolean bezahlt;

    @Enumerated(EnumType.STRING)
    private Erfüllung erfüllung;

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

    public Erfüllung getErfüllung() {
        return erfüllung;
    }

    public void setErfüllung(Erfüllung erfüllung) {
        this.erfüllung = erfüllung;
    }
}
