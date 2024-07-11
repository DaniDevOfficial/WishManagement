package com.example.abschlussm223.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Buchung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buchungId;

    private Date datum;

    @Enumerated(EnumType.STRING)
    private MietZeit mietZeit;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Long getBuchungId() {
        return buchungId;
    }

    public void setBuchungId(Long buchungId) {
        this.buchungId = buchungId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public MietZeit getMietZeit() {
        return mietZeit;
    }

    public void setMietZeit(MietZeit mietZeit) {
        this.mietZeit = mietZeit;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
