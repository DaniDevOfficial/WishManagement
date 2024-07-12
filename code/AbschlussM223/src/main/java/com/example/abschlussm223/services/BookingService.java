package com.example.abschlussm223.services;

import com.example.abschlussm223.models.Booking;
import com.example.abschlussm223.models.Fulfilled;
import com.example.abschlussm223.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

// Add a method to create a booking
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

// Add a method to delete a booking
    public Booking deleteBooking(Booking booking) {
        bookingRepository.deleteById(booking.getBookingId());
        return booking;
    }
}
