package com.move.userService.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD}) // This tells Java we use this on class variables
@Retention(RetentionPolicy.RUNTIME) // This tells Java to keep the rule active while the app runs
@Constraint(validatedBy = PhoneValidator.class) // The "Bridge" to your logic class
public @interface ValidPhone {
    // The message that shows up in Postman if validation fails
    String message() default "Invalid Indian phone number. Must be 10 digits starting with 6-9";

    // Required by the Spring Validation API (don't remove these)
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
