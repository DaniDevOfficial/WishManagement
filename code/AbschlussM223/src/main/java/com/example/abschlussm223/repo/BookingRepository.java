package com.example.abschlussm223.repo;
import com.example.abschlussm223.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    void deleteById(Long id);

    Optional<Booking> findById(Long id);
}