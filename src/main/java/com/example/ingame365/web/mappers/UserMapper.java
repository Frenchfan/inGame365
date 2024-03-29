package com.example.ingame365.web.mappers;

import com.example.ingame365.domain.entities.user.User;
import com.example.ingame365.web.dto.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDto toDto(User user);


    User toEntity(UserDto dto);

    List<UserDto> toDto(List<User> users);
}
