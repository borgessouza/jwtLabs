package br.com.ks.jwt.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    public String doGenerateToken(Map<String, Object> claims, String payload) {
        return Jwts.builder()
                .setPayload(payload)
                .signWith(SignatureAlgorithm.HS512, "password")
                .compact();
    }



}
