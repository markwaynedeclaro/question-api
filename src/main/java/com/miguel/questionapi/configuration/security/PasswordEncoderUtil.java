package com.miguel.questionapi.configuration.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);

        String secret = Base64.getEncoder().encodeToString(Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256).getEncoded());
        System.out.println("Generated Secret Key: " + secret);
    }
}
