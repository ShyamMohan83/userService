package com.move.userService.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        // If the phone number is null, let @NotNull handle it, otherwise this fails
        if (phoneNumber == null) {
            return false;
        }

        /* Regex Explained:
           ^       : Start of string
           [6-9]   : First digit must be 6, 7, 8, or 9 (Indian standard)
           \\d{9}  : Followed by exactly 9 more digits
           $       : End of string
        */
        return phoneNumber.matches("^[6-9]\\d{9}$");
    }
}
