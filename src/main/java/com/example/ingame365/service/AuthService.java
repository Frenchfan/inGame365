package com.example.ingame365.service;

import com.example.ingame365.web.dto.auth.JwtRequest;
import com.example.ingame365.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);
}
