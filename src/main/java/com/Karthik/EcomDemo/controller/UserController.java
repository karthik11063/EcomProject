package com.Karthik.EcomDemo.controller;

import com.Karthik.EcomDemo.dto.UserDTO;
import com.Karthik.EcomDemo.dto.UserResponseDTO;
import com.Karthik.EcomDemo.mapper.UserMapper;
import com.Karthik.EcomDemo.repo.UserRepo;
import com.Karthik.EcomDemo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    /**
     * Endpoint to register a new user
     * @param userDTO
     * @return ResponseEntity with registration status
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO userDTO){
        ResponseEntity<String> response = userService.registerUser(userDTO);
        return response;
    }
    /**
     * Endpoint to get user details by ID
     * @param id
     * @return ResponseEntity with UserDTO if found, or 404 if not found
     */
    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
      ResponseEntity<UserResponseDTO> response = userService.getUserById(id);
        return response;
    }
    /**
     * Endpoint to update user details by ID
     * @param id
     * @param userDTO
     * @return ResponseEntity with updated UserDTO if found, or 404 if not found
     */
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        ResponseEntity<UserResponseDTO> updateResponse = userService.updateUser(id, userDTO);
        return updateResponse;
    }
    /**
     * Endpoint to delete a user by ID
     * @param id
     * @return ResponseEntity with deletion status
     */
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        ResponseEntity<String> response = userService.deleteUser(id);
        return response;
    }
}
