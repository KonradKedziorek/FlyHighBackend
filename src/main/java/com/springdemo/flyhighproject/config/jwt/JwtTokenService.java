package com.springdemo.flyhighproject.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtTokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private long validity;

    public String generateToken(Map<String, Object> claims, String subject){
        String token = Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
        return token;
    }

    public Map<String, Object> buildClaims(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put("ROLE", userDetails.getAuthorities().stream().map(i -> i.getAuthority()).collect(Collectors.toList()));
        return claims;
    }

    public Claims getClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
    }

    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsFunction){
        Claims claims = getClaimsFromToken(token);
        return claimsFunction.apply(claims);
    }
}
