package com.example.abschlussm223.controller;

import com.example.abschlussm223.models.Booking;
import com.example.abschlussm223.services.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/")
    @Operation(summary = "Create a new booking", description = "Create a new booking with the given data",
        tags = {"booking"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Booking created successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a booking", description = "Delete a booking with the given data",
        tags = {"booking"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Booking deleted successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        String Res = bookingService.deleteBooking(id);
        return new ResponseEntity<>(Res, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Cancel a booking", description = "Cancel a booking with the given data",
        tags = {"booking"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Booking canceled successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id) {
        Booking savedBooking = bookingService.cancelBooking(id);
        return new ResponseEntity<>(savedBooking, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get a booking by id", description = "Get a booking by id",
        tags = {"booking"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Booking found"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        Booking savedBooking = bookingService.getBookingById(id);
        return new ResponseEntity<>(savedBooking, HttpStatus.OK);
    }
}
