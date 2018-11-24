package seal.VideoService.Filter;

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

    public static long EXPIRATION_TIME = 1000 * 30; // 30 seconds timeout
    static Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        System.out.println("Get Authentication : " + token);
        if (token != null) {
            // parse the token.
            String user = null;
            // ถ้าเอา Try Catch ออกมันจะบึ้มแล้ว ใชช้สิทธิต่างๆไมไ่ด้
            try {
                user = Jwts.parser() // แปลง token ที่รับมาจาก request ได้ค่า user.getId() ที่เราเก็บไว้
                        .setSigningKey(SECRET_KEY)
                        .parseClaimsJws(token.replace("Bearer", ""))//ไม่ต้องมีก็ได้เพราะไม่ใช้ Bearer 
                        .getBody()
                        .getSubject();
            } catch (JwtException jwtException) {
                System.out.println("!!! Exception /: " + jwtException.getMessage());
                System.out.println(user);
                return null;

            }

            return user != null
                    ? new UsernamePasswordAuthenticationToken(user, null, emptyList())
                    : // ถ้า user ไม่ใช่ null ให้ส่งค่า user ว่าผ่านได้
                    null;
        }
        return null;
    }

}
