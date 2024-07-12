package com.example.abschlussm223.controller;

import com.example.abschlussm223.models.Booking;
import com.example.abschlussm223.services.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/create")
    @Operation(summary = "Create a new booking", description = "Create a new booking with the given data",
        tags = {"booking"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Booking created successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    @Operation(summary = "Delete a booking", description = "Delete a booking with the given data",
        tags = {"booking"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Booking deleted successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<Booking> deleteBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.deleteBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.OK);
    }

}
