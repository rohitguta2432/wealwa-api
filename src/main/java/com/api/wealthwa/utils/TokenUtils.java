package com.api.wealthwa.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;



/**
 * @Author rohit
 * @Date 16/05/22
 **/

@Service
public class TokenUtils {

    @Value("${expense.secret.token}")
    private String secretToken;

    public String getUsernameFromToken(String token) {
        final Claims claim = getClaimsFromToken(token);
        return claim.getSubject();
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretToken)
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", username);
        return generateToken(claims);
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts
                .builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretToken).compact();
    }
}
