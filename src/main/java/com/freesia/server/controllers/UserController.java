package com.freesia.server.controllers;

import com.freesia.server.models.User;
import com.freesia.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping({"/users"})
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(produces = "application/json")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<User>> users() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
