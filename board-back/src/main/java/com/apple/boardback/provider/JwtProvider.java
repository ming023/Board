package com.apple.boardback.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.sterotype.Component;

@Component
public class JwtProvider {
    private String secretkey = "S3cr3tk3y";

    public String create(String email) {
        
        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS))
        
        String jwt = Jwts.builder()
            .signwith(SignatureAlgorithm.ES256, secretkey)
            .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredDate)
            .compact();
        }

        public String validate(String jwt)

            claims claims =null;

            try {
                claims = jwts.parser().setSigngkey(secretkey)
                    .parseClaimsJws(jwt).getBody();
            } catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }

            return claims.getSubject();

}