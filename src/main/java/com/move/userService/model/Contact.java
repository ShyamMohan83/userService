package com.move.userService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.move.userService.validation.ValidPhone;
import lombok.Data;


public class Contact {
    private Long id;
    private Long userId;
    private String emailId;
    @ValidPhone
    private String phoneNumber;
    @JsonProperty("isPrimary")
    private boolean isPrimary;

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
