package com.move.userService.controller;

import com.move.userService.model.*;
import com.move.userService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRegistrationDTO userDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.userService.userRegistration(userDTO));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Unable to create user" + e.getMessage()));
        }
    }
    @GetMapping
    public ResponseEntity<?> getUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch(Exception e) {
            ErrorResponse error = new ErrorResponse("Failed to fetch the user" + e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity
                    .badRequest().body(error);
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> getUserDetails(@PathVariable("id") Long id) {
        try {
            return  ResponseEntity.ok(userService.getUserDetails(id));
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse("Failed to fetch the user" + e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity
                    .badRequest().body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserDetail(@PathVariable("id") Long id, @RequestBody UserRegistrationDTO userDTO) {
        try{
            return ResponseEntity.ok(userService.updateUserDetail(userDTO, id));
        } catch(Exception e) {
            ErrorResponse error = new ErrorResponse("Failed to update the user" + e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity
                    .badRequest().body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserDetails(@PathVariable("id") Long id , @RequestBody User user) {

        try{
            return ResponseEntity.ok(userService.deleteUser(user, id));
        } catch(Exception e) {
            ErrorResponse error = new ErrorResponse("Failed to update the user" + e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity
                    .badRequest().body(error);
        }
    }

}
