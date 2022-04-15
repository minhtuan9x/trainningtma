package com.dominhtuan.exercise1.util;

import com.dominhtuan.exercise1.dto.MyUserDetail;
import com.dominhtuan.exercise1.dto.response.JwtResponse;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
public class JwtUtil {
    /*
    Tạo JWT từ username, date, expiration và secret
    Lấy username từ JWT
    Xác nhận JWT
     */
    private static final String JWT_SECRET = "dog";
    private static final int JWT_EXPIRATION_MS = 86400000;

    public static JwtResponse generateJwtToken(Authentication authentication) {
        MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

        String token = Jwts.builder()
                .setSubject(myUserDetail.getUsername())//set user name
                .setIssuedAt(new Date())//set start time
                .setExpiration(new Date(new Date().getTime() + JWT_EXPIRATION_MS))//set expiration time
                .signWith(SignatureAlgorithm.HS256, enCodedBase64(JWT_SECRET))//use decode
                .compact();
        return new JwtResponse(token, myUserDetail.getUsername(), myUserDetail.getEmail(), myUserDetail.getFullName(), myUserDetail.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
    }

    public static String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(enCodedBase64(JWT_SECRET)).parseClaimsJws(token).getBody().getSubject();
    }

    public static boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(enCodedBase64(JWT_SECRET)).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    private static String enCodedBase64(String jwtSecretKey) {
        return Base64.getEncoder().encodeToString(jwtSecretKey.getBytes());
    }
}
