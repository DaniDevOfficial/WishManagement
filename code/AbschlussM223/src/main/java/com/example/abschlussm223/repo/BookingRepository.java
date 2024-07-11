package com.example.abschlussm223.repo;
import com.example.abschlussm223.models.Buchung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuchungRepository extends JpaRepository<Buchung, Long> {}