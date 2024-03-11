package com.example.ingame365.web.controller;

import com.example.ingame365.domain.entities.user.User;
import com.example.ingame365.service.AuthService;
import com.example.ingame365.service.UserService;
import com.example.ingame365.web.dto.auth.JwtRequest;
import com.example.ingame365.web.dto.auth.JwtResponse;
import com.example.ingame365.web.dto.user.UserDto;
import com.example.ingame365.web.dto.validation.OnCreate;
import com.example.ingame365.web.mappers.UserMapper;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Tag(name = "Auth Controller", description = "Auth API")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;
    private final ApplicationContext context;

    @PostMapping("/login")
    @Operation(summary = "User login")
    public ResponseEntity<JwtResponse> login(@Validated @RequestBody JwtRequest loginRequest) {
        return ResponseEntity.ok()
                .body(authService.login(loginRequest));
    }

    @PostMapping("/register")
    @Operation(summary = "Create user")
    public UserDto register(@Validated(OnCreate.class)
                                @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        System.out.println(user);
        user.setLastName(userDto.getLastName());
        user.setCreatedAt(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
        User createdUser = userService.create(user);
        return createdUser.toDto(createdUser);
    }

    @PostMapping("/refresh")
    @Operation(summary = "Refresh access token")
    public JwtResponse refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }

}
