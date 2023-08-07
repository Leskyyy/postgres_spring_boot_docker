package com.odazie.simpleblog.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil
{

    private static final String SECRET_KEY =
        "32b968789977db75a18fc71fb4df663c071b679176508d01ff2e4bfba1ea85a9";

    public String extractEmail( String jwt )
    {
        return extractClaim( jwt, Claims::getSubject );
    }

    public < T > T extractClaim( String jwt, Function< Claims, T > claimsResolver )
    {
        final Claims claims = extractAllClaims( jwt );
        return claimsResolver.apply( claims );
    }

    public String generateToken(Map< String, Object > claims, UserDetails userDetails )
    {
        return createToken( claims, userDetails.getUsername() );
    }

    private Claims extractAllClaims( String jwt )
    {
        return Jwts.parserBuilder()
            .setSigningKey( getSignInKey() )
            .build()
            .parseClaimsJws( jwt )
            .getBody();
    }

    private Key getSignInKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode( SECRET_KEY );
        return Keys.hmacShaKeyFor( keyBytes );
    }
}
