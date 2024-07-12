package com.example.abschlussm223.services;

import com.example.abschlussm223.models.Role;
import com.example.abschlussm223.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role) {
        Optional<Role> existingRole = roleRepository.findByName(role.getName());
        if (existingRole.isPresent()) {
            throw new IllegalStateException("Role already exists");
        }
        return roleRepository.save(role);
    }
}
