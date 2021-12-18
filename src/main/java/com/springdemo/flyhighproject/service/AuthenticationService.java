package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.config.jwt.JwtResponse;
import com.springdemo.flyhighproject.config.jwt.JwtTokenService;
import com.springdemo.flyhighproject.model.AuthRequest;
import com.springdemo.flyhighproject.model.CustomAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private AccountService accountService;

    public JwtResponse authenticate(AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            UserDetails userDetails = accountService.loadUserByUsername(authRequest.getUsername());
            Map<String, Object> claims  = jwtTokenService.buildClaims(userDetails);
            String token = jwtTokenService.generateToken(claims, authRequest.getUsername());
            return new JwtResponse(token);
        }catch (BadCredentialsException e){
            throw new Exception("Bad credentials", e);
        }
    }
}
