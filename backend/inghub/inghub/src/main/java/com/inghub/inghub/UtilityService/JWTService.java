package com.inghub.inghub.UtilityService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTService {

    @Value("{spring.app.JwtSecret}")
    private String key;

    @Value("${spring.app.expirationTime}")
    private int expiration;

    public String generateJwtToken(String username){
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ 1000* 60*60*30))
                .and()
                .signWith(getKey()).compact();
    }
//    private Key getKey() {
//
//        byte[] keyBytes = Decoders.BASE64.decode("mySecretKey");
//        return Keys.hmacShaKeyFor(keyBytes) ;
//    }
private Key getKey() {
    // Base64 encode the string "mySecretKey"
    String encodedKey = Base64.getEncoder().encodeToString("LetsNottellthemIdidItelseWeareFukedon".getBytes(StandardCharsets.UTF_8));

    // Now decode it back
    byte[] keyBytes = Decoders.BASE64.decode(encodedKey);

    return Keys.hmacShaKeyFor(keyBytes);
}
    public String getUsernameFromToken(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().verifyWith((SecretKey) getKey())
                    .build()
                    .parse(token);
            return true;
        } catch (Exception e){

        }
        return false;
    }
}
