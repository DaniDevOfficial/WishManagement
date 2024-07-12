package com.example.abschlussm223.controller;

import com.example.abschlussm223.models.Role;
import com.example.abschlussm223.services.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")


public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    @Operation(summary = "Create a new role", description = "Create a new role with the given name",
        tags = {"role"},responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Role created successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        try {
            Role savedRole = roleService.createRole(role);
            return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
