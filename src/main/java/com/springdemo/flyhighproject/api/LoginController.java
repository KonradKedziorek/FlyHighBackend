package com.springdemo.flyhighproject.api;


import com.springdemo.flyhighproject.config.jwt.JwtResponse;
import com.springdemo.flyhighproject.config.jwt.JwtTokenService;
import com.springdemo.flyhighproject.model.AuthRequest;
import com.springdemo.flyhighproject.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthRequest authRequest) throws Exception {
        return ResponseEntity.ok(authenticationService.authenticate(authRequest));
    }
}
