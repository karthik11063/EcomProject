package com.Karthik.EcomDemo.mapper;

import com.Karthik.EcomDemo.dto.ProductDTO;
import com.Karthik.EcomDemo.dto.UserDTO;
import com.Karthik.EcomDemo.dto.UserResponseDTO;
import com.Karthik.EcomDemo.model.Product;
import com.Karthik.EcomDemo.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
        UserDTO toUserDTO(User user);
        User toUser(UserDTO userDTO);
        UserResponseDTO toUserResponseDTO(User user);

}
