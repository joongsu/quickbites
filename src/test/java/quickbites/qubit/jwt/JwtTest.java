package quickbites.qubit.jwt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quickbites.qubit.domain.user.entity.Role;
import quickbites.qubit.global.util.jwt.JwtUtil;

import javax.crypto.spec.SecretKeySpec;

import java.time.Duration;


public class JwtTest {

    private JwtUtil jwtUtil;


    @BeforeEach
    void setup() {
        byte[] keyBytes = "GjCU1g8/AbJhSzj4McaCKa7Amu+Fz1N4w8jJfZanEIk=".getBytes(); // 테스트용 키

        jwtUtil = new JwtUtil(
                new SecretKeySpec(keyBytes, "HmacSHA256"),
                Duration.ofDays(10000),
                Duration.ofDays(7),
                "issuer"
        );
    }

    @Test
    void generateTokenTest(){

        String accessToken = jwtUtil.generateAccessToken("hello", Role.USER.toString());
        String refreshToken = jwtUtil.generateRefreshToken("hello", Role.USER.toString());
        System.out.println("token = " + accessToken);
        System.out.println("refreshToken = " + refreshToken);
    }
}
