package edu.duke.summer.server.jwt;

import edu.duke.summer.server.service.impl.MyUserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * Provide Method for generating, parsing, validating JWT
 */
@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${duke.edu.summer.app.jwtSecret}")
    private String jwtSecret;
    @Value("${duke.edu.summer.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    /*
     * Helper Function
     */
    public String generateJwtToken(MyUserDetailsImpl userPrincipal) {
        return generateTokenFromUsername(userPrincipal.getUsername());
    }

    /*
     * Generate Token for new Registration
     * The Subject is depends on username
        {
         Issuer:DiceRolling_Yuxuan,
         Subject: username,
         IssuedAt: date,
         Expiration: date+expirationMs,
         signature: HS512
        }
     */
    public String generateTokenFromUsername(String username) {
        return Jwts.builder().setIssuer("DiceRolling_Yuxuan").setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
