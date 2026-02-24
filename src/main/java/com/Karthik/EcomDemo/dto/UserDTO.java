package com.Karthik.EcomDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    @NotBlank(message = "Name is required")
    @Size(min=2,max=10,message="Name should be between 2 and 10 characters")
    private String userName;
    @Email(message="Email should be valid")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min=6,message="Password should be at least 6 characters")
    private String password;
}
