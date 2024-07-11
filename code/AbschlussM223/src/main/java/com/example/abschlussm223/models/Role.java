package com.example.abschlussm223.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolleId;

    private String rollenName;

    // Getter und Setter Methoden

    public Long getRolleId() {
        return rolleId;
    }

    public void setRolleId(Long rolleId) {
        this.rolleId = rolleId;
    }

    public String getRollenName() {
        return rollenName;
    }

    public void setRollenName(String rollenName) {
        this.rollenName = rollenName;
    }
 }
