package com.Karthik.EcomDemo.service;

import com.Karthik.EcomDemo.dto.UserDTO;
import com.Karthik.EcomDemo.dto.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> registerUser(@Valid UserDTO userDTO);

    ResponseEntity<UserResponseDTO> getUserById(Long id);

    ResponseEntity<UserResponseDTO> updateUser(Long id,UserDTO userDTO);

    ResponseEntity<String> deleteUser(Long id);
}
