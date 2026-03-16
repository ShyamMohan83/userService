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
    public ResponseEntity<UserRegistrationDTO> createUser(@RequestBody UserRegistrationDTO userDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService.userRegistration(userDTO));
    }
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public  ResponseEntity<UserDetailResponse> getUserDetails(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(userService.getUserDetails(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRegistrationDTO> updateUserDetail(@PathVariable("id") Long id, @RequestBody UserRegistrationDTO userDto) {
        return ResponseEntity.ok(userService.updateUserDetail(userDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserDetails(@PathVariable("id") Long id , @RequestBody User user) {
        return ResponseEntity.ok(userService.deleteUser(user, id));
    }

}
