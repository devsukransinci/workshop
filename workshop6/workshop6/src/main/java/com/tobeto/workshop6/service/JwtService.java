package com.tobeto.workshop6.service;

import com.tobeto.workshop6.entity.Kullanici;
import com.tobeto.workshop6.repository.KullaniciRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class JwtService {
    private static final String KEY = "EQSgDRzblCZb5jkUu4PiruKOMDNf+D+5oLHm+qtM3ehjCFyq3C/yImlGCs4/BDUF4QV8qUUgwt9SXGusa4pcTA==";

    @Autowired
    private KullaniciRepository kullaniciRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String tokenUret(UserDetails user) {
        Optional<Kullanici> oKullanici = kullaniciRepository.findByEmail(user.getUsername());
        if (oKullanici.isPresent()
                && passwordEncoder.matches(user.getPassword(), oKullanici.get().getSifre())) {

            return tokenUser(oKullanici.get());

        }
        throw new UsernameNotFoundException("Not Found");
    }

    private String tokenUser(Kullanici kullanici) {
        JwtBuilder builder = Jwts.builder();

        String[] roller = { "admin", "user" };


        Map<String, Object> customKeys = new HashMap<>();
        customKeys.put("roller", roller);
        builder = builder.claims(customKeys);

        Instant tarih = Instant.now().plus(15, ChronoUnit.MINUTES);

        builder = builder.subject("login").id(kullanici.getEmail()).issuedAt(new Date())
                .expiration(Date.from(tarih));

        return builder.signWith(getKey()).compact();
    }

    public Claims tokenKontrol(String token) {
        JwtParser builder = Jwts.parser().verifyWith(getKey()).build();
        return builder.parseSignedClaims(token).getPayload();
    }

    private static SecretKey getKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEY));
        return key;
    }
}
