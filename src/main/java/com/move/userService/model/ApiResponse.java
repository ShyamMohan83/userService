package com.move.userService.model;

import lombok.Data;

@Data
public class ApiResponse {
    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // MANUAL CONSTRUCTOR - This forces the IDE to see it
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // EMPTY CONSTRUCTOR - Required for JSON
    public ApiResponse() {}
}