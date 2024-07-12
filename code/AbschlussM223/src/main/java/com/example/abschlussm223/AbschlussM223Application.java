package com.example.abschlussm223;

import com.example.abschlussm223.models.*;
import com.example.abschlussm223.repo.BookingRepository;
import com.example.abschlussm223.repo.RoleRepository;
import com.example.abschlussm223.repo.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootApplication
public class AbschlussM223Application {

    @Bean
    @Profile("dev")
    public ApplicationRunner runner(UserRepository userRepository, BookingRepository bookingRepository, RoleRepository roleRepository) {
        return args -> {
            createInitialData(userRepository, bookingRepository, roleRepository);
        };
    }

    @Transactional
    public void createInitialData(UserRepository userRepository, BookingRepository bookingRepository, RoleRepository roleRepository) {
        // Create and save a new role
        Role role = new Role();
        role.setName("Visitor");
        roleRepository.save(role);

        // Create and save a new user
        User user = new User();
        user.setRole(role);
        user.setFirstname("Admin");
        user.setLastname("Admin");
        user.setEmail("admin@admin.admin");
        user.setPassword("admin");
        userRepository.save(user);


// Create and save a new booking
        Booking booking = new Booking();
        booking.setDate(new Date());
        booking.setPaid(false);
        booking.setFulfilled(Fulfilled.FULLFILLED);
        booking.setRentTime(RentTime.FULL_DAY);
        booking.setUser(user);
        bookingRepository.save(booking);

    }

    public static void main(String[] args) {
        SpringApplication.run(AbschlussM223Application.class, args);
    }
}
