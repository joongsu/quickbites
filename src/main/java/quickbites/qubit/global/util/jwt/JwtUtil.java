package quickbites.qubit.global.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import quickbites.qubit.domain.User.Role;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.Duration;
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey secretKey;
    private final Duration accessTokenDuration;
    private final Duration refreshTokenDuration;
    private final String issuer;

    public JwtUtil(
            @Value("${JWT_SECRET_KEY)")SecretKey secretKey,
            @Value("${JWT_ACCESS_EXPIRATION")Duration accessTokenDuration,
            @Value("${JWT_REFRESH_EXPIRATION")Duration refreshTokenDuration,
            @Value("${JWT_ISSUER}") String issuer
    ){
        this.secretKey = new SecretKeySpec(secretKey.getEncoded(), Jwts.SIG.HS256.key().build().getAlgorithm());
        this.accessTokenDuration = accessTokenDuration;
        this.refreshTokenDuration = refreshTokenDuration;
        this.issuer = issuer;
    }

    public String generateAccessToken(String userId, Role role){
        return Jwts.builder()
                .subject(userId)
                .issuedAt(new Date())
                .issuer(issuer)
                .expiration(createExpire(accessTokenDuration.toMillis()))
                .claim("role",role)
                .claim("tokenType","access")
                .signWith(secretKey)
                .compact();
    }

    public String generateRefreshToken(String userId, Role role){
        return Jwts.builder()
                .subject(userId)
                .issuedAt(new Date())
                .issuer(issuer)
                .expiration(createExpire(refreshTokenDuration.toMillis()))
                .claim("role",role)
                .claim("tokenType","refresh")
                .signWith(secretKey)
                .compact();
    }

    public Claims parseToken(String token){
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)   //jwt 토큰 전체
                .getPayload();
    }

    private Date createExpire(Long expiration){
        return new Date(System.currentTimeMillis() + expiration);
    }
}
