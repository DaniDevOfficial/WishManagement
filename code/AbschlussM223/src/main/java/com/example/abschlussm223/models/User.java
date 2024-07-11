package com.example.abschlussm223.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String vorname;
    private String nachname;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "rolleId")
    private Role rolle;

    @OneToMany(mappedBy = "user")
    private List<Booking> buchungen;
}
