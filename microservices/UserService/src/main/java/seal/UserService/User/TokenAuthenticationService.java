package seal.UserService.User;

import java.security.Key;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.ArrayList;

import static java.util.Collections.emptyList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class TokenAuthenticationService {

    public static long EXPIRATION_TIME = 1000 * 300000; // 30 seconds timeout
    static Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String createTokenUser(User user) {
        Date now = new Date();
        HashMap<String, Object> userJson = new HashMap<>();
        userJson.put("userId", user.getId());
        userJson.put("userImg", user.getImage());
        userJson.put("userName", user.getFirstname());

        String token = Jwts.builder()
                .claim("user", userJson)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
        return token;
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        System.out.println("Get Authentication : " + token);
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();

            return user != null
                    ? new UsernamePasswordAuthenticationToken(user, null, emptyList())
                    : null;
        }
        return null;
    }

}
