package com.example.abschlussm223;

import com.example.abschlussm223.models.*;
import com.example.abschlussm223.repo.BookingRepository;
import com.example.abschlussm223.repo.RoleRepository;
import com.example.abschlussm223.repo.StatusRepository;
import com.example.abschlussm223.repo.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootApplication
public class AbschlussM223Application {

    @Bean
    public ApplicationRunner runner(UserRepository userRepository, BookingRepository bookingRepository, StatusRepository statusRepository, RoleRepository roleRepository) {
        return args -> {
            createInitialData(userRepository, bookingRepository, statusRepository, roleRepository);
        };
    }

    @Transactional
    public void createInitialData(UserRepository userRepository, BookingRepository bookingRepository, StatusRepository statusRepository, RoleRepository roleRepository) {
        // Create and save a new role
        Role role = new Role();
        role.setRoleName("Admin");
        roleRepository.save(role);

        // Create and save a new user
        User user = new User();
        user.setRole(role);
        user.setFirstname("Admin");
        user.setLastname("Admin");
        user.setEmail("admin@admin.admin");
        user.setPassword("admin");
        userRepository.save(user);

        // Create and save a new status
        Status status = new Status(true, Fulfilled.FULLFILLED);
        statusRepository.save(status);

// Create and save a new booking
        Booking booking = new Booking();
        booking.setDatum(new Date());
        booking.setStatus(status);
        booking.setRentTime(RentTime.FULL_DAY);
        booking.setUser(user);
        bookingRepository.save(booking);
        
    }

    public static void main(String[] args) {
        SpringApplication.run(AbschlussM223Application.class, args);
    }
}
