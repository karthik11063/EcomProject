package com.Karthik.EcomDemo.service;

import com.Karthik.EcomDemo.dto.UserDTO;
import com.Karthik.EcomDemo.dto.UserResponseDTO;
import com.Karthik.EcomDemo.mapper.UserMapper;
import com.Karthik.EcomDemo.model.User;
import com.Karthik.EcomDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepo userRepo;
    @Override
    public ResponseEntity<String> registerUser(UserDTO userDTO) {
        User registerUser = userMapper.toUser(userDTO);
        userRepo.save(registerUser);
        return ResponseEntity.ok("User registered successfully");
    }

    @Override
    public ResponseEntity<UserResponseDTO> getUserById(Long id) {
       Optional<User> user = userRepo.findById(id);
       if(user.isPresent()){
              UserResponseDTO userDTO = userMapper.toUserResponseDTO(user.get());
              return ResponseEntity.ok(userDTO);
       }
       else{
           return ResponseEntity.notFound().build();
       }
    }

    @Override
    public ResponseEntity<UserResponseDTO> updateUser(Long id,UserDTO userDTO) {
        Optional<User> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setUserName(userDTO.getUserName());
            userToUpdate.setEmail(userDTO.getEmail());
            userRepo.save(userToUpdate);
            UserResponseDTO updatedUserDTO = userMapper.toUserResponseDTO(userToUpdate);
            return ResponseEntity.ok(updatedUserDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        Optional<User> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            userRepo.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
