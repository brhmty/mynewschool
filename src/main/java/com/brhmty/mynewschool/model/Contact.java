package com.brhmty.mynewschool.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Contact {

    @NotBlank(message = "This place can not be empty.")
    @Size(min=3, message = "Name must be at least 3 characters long.")
    private String name;

    @NotBlank(message = "This place can not be empty.")
    @Pattern(regexp = "(^(?!(0))[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "This place can not be empty.")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "This place can not be empty.")
    @Size(min=5, message = "Subject must be at least 5 characters long.")
    private String subject;

    @NotBlank(message = "This place can not be empty.")
    @Size(min=10, message = "Message must be at least 10 characters long.")
    private String message;
}
