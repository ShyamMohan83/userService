package com.move.userService.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
public class User {
    private Long userId;       // CamelCase is standard for Java
    private String externalId;
    @NotBlank(message="First name should not be empty")
    @Size(min=3, max = 50, message="First name should be minimum 3 and maximum 50")
    private String firstName;
    @NotBlank(message="Last name should not be empty")
    @Size(min=3, max=50, message="Last name should be minimum 3 and maximum 50")
    private String lastName;
    @NotBlank(message = "user name should not be empty")
    @Size(min=5, max=50, message="user name should be minimum 5 and maximum 50")
    private String userName;
    @NotBlank(message = "Role should not blank")
    @Size(min=5, max=10, message = "Role should be minimum 5 and maximum 10")
    private String role;
    @NotBlank(message = "Current State should not blank")
    @Size(min=5, max=10, message = "Current State should be minimum 5 and maximum 10")
    private String currentState;
    @NotNull(message="Is active should not be empty or null")
    private boolean isActive;
    private Timestamp lastLogin;
    private Timestamp deletedAt;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }
}

