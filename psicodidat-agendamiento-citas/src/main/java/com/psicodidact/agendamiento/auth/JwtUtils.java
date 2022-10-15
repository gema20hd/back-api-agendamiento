package com.psicodidact.agendamiento.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Component
public class JwtUtils {

    private String SECRET_KEY = "examportal";

    public String extractUsername(String token) {
      	System.out.println("METODO EXTRACT USERNAME");
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
      	System.out.println("METODO EXTRACT EXPIRATION");
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
      	System.out.println("METODO EXTRACT CLAIMS");
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
    	System.out.println("METODO EXTRACT all CLAIMS");
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
    	System.out.println("METODO IS TOKEN EXPIRED");
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
    	System.out.println("METODO GENERATE TOKEN");
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }
   //reclamaciones
    private String createToken(Map<String, Object> claims, String subject) {
    	System.out.println("METODO CREATE TOKEN");
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
    	System.out.println("METODO VALIDAR TOKEN");
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
