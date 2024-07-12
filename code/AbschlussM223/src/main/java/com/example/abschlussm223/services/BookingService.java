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

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public String deleteBooking(Long bookingId) {
        if (!bookingRepository.existsById(bookingId)) {
            return ("Booking not found");
        }
        bookingRepository.deleteById(bookingId);

        return "Booking deleted successfully";
    }

    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).
                orElseThrow(() -> new IllegalStateException("Booking not found"));
        booking.setFulfilled(Fulfilled.CANCLED);
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
}
