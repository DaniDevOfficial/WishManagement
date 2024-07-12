package com.example.abschlussm223.controller;

import com.example.abschlussm223.models.Role;
import com.example.abschlussm223.models.User;
import com.example.abschlussm223.repo.RoleRepository;
import com.example.abschlussm223.repo.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("Email already in use", HttpStatus.CONFLICT);
        }

        // Fetch or create default role
        Role defaultRole = roleRepository.findByName("Visitor")
                .orElseGet(() -> roleRepository.save(new Role() {{
                    setName("Visitor");
                }}));

        // Set default role
        user.setRole(defaultRole);
        user.setPassword(user.getPassword());
        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@Valid @RequestBody User loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return new ResponseEntity<>("User authenticated successfully", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
    }
}
