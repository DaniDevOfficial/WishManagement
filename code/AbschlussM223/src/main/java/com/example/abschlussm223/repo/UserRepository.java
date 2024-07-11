package com.example.abschlussm223.repo;

import com.example.abschlussm223.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
