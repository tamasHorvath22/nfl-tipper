package com.codecool.common;

import com.codecool.dto.UserDTO;
import com.codecool.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class UserMapper {

    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static UserDTO toDto(User user) {
        return modelMapper().map(user, UserDTO.class);
    }

    public static User toEntity(UserDTO userDTO) {
        return modelMapper().map(userDTO, User.class);
    }

}
