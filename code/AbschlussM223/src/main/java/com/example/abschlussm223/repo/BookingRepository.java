package com.example.abschlussm223.repo;
import com.example.abschlussm223.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {}