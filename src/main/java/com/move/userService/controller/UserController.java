package com.move.userService.controller;

import com.move.userService.model.ApiResponse;
import com.move.userService.model.User;
import com.move.userService.model.UserRegistrationDTO;
import com.move.userService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return null;
    } // in -progress
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserRegistrationDTO userDTO) {
        try {
            this.userService.userRegistration(userDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ApiResponse(true, "User created successfully"));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "unable to create user" + e.getMessage()));
        }

    }
}
