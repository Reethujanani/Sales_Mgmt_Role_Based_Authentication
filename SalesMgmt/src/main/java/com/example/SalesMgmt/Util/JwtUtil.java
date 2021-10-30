package com.example.SalesMgmt.Util;

import com.example.SalesMgmt.Entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public class JwtUtil {

    public static String generateToken(String subject, long userId, List<Role> roles, String userName) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .claim("userId", userId)
                .claim("roles", roles)
                .claim("userName", userName).setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, "secret");


        return builder.compact();
    }



    public String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }


    public boolean validateToken(String authToken,String signingKey) {
        try {
            Jwts.parser().setSigningKey("secret").parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Having Error in the parsing the Token");
        }
    }


    public static String getUserNameFromJWTs(String token, String signingKey) {
        Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
        return String.valueOf(claims.get("userName"));
    }

    /*public static String getIdFromJWTs(String token, String signingKey) {
        Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
        return String.valueOf(claims.get("ownerId"));
    }*/


}