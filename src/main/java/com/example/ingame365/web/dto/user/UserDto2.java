package com.example.ingame365.web.dto.user;

import com.example.ingame365.domain.entities.user.Role;
import com.example.ingame365.domain.entities.user.User;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto2 {
    private String username;
    private Set<Role> roles;

    public UserDto2(User user) {
        this.username = user.getUsername();
        this.roles = user.getRoles();
    }
}
