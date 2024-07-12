package com.example.abschlussm223.services;

import com.example.abschlussm223.models.Role;
import com.example.abschlussm223.models.User;
import com.example.abschlussm223.repo.RoleRepository;
import com.example.abschlussm223.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public void registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("Email already in use");
        }

        Role defaultRole = roleRepository.findByName("Visitor")
                .orElseGet(() -> roleRepository.save(new Role() {{
                    setName("Visitor"); // copilot
                }}));

        user.setRole(defaultRole);
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

    public boolean authenticateUser(User loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getPassword().equals(loginRequest.getPassword());
        }
        return false;
    }
}
