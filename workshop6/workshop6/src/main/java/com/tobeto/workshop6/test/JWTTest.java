package com.tobeto.workshop6.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {
    private static final String KEY = "EQSgDRzblCZb5jkUu4PiruKOMDNf+D+5oLHm+qtM3ehjCFyq3C/yImlGCs4/BDUF4QV8qUUgwt9SXGusa4pcTA==";

    public static void main(String[] args) {

        String jwt = tokenUret();
        System.out.println(jwt);
        Claims claims = tokenCheck(jwt);
        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Id: " + claims.getId());
        System.out.println("Adı: " + claims.get("adi"));
        System.out.println("Soyadı: " + claims.get("soyadi"));
    }

    public static Claims tokenCheck(String jwt) {
        JwtParser builder = Jwts.parser().verifyWith(getKey()).build();
        Claims claims = builder.parseSignedClaims(jwt).getPayload();
        return claims;
    }

    public static String tokenUret() {
        JwtBuilder builder = Jwts.builder();


        Map<String, Object> customKeys = new HashMap<>();
        customKeys.put("adi", "SUKRAN");
        customKeys.put("soyadi", "SINCI");
        builder = builder.claims(customKeys);

        Instant tarih = Instant.now().plus(15, ChronoUnit.MINUTES);

        builder = builder.subject("login").id("13-23-ab").issuedAt(new Date()).expiration(Date.from(tarih));

        String jwt = builder.signWith(getKey()).compact();
        return jwt;
    }

    public static void keyUret() {
        SecretKey key = Jwts.SIG.HS512.key().build();
        String str = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(str);
    }

    public static SecretKey getKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEY));
        return key;
    }

}
