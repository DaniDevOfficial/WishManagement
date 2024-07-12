package com.example.abschlussm223.controller;

import com.example.abschlussm223.models.User;
import com.example.abschlussm223.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Register a new user", description = "Register a new user with the given email and password",
        tags = {"user"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "User registered successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input"),
    })
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {

        try {
            userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    @Operation(summary = "Authenticate a user", description = "Authenticate a user with the given email and password",
        tags = {"user"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "User authenticated successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Invalid email or password"),
    })

    public ResponseEntity<String> authenticateUser(@Valid @RequestBody User loginRequest) {
        if (userService.authenticateUser(loginRequest)) {
            return new ResponseEntity<>("User authenticated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
    }

    // admin routes
    @PutMapping("/update")
    @Operation(summary = "Update a user", description = "Update a user with the given data",
        tags = {"user"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "User updated successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        String res = userService.updateUser(user);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user", description = "Delete a user with the given data",
        tags = {"user"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "User deleted successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String res = userService.deleteUser(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
