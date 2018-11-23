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

import static java.util.Collections.emptyList;
import java.util.HashMap;

@Service
public class TokenAuthenticationService {

    public static long EXPIRATION_TIME = 1000 * 30; // 30 seconds timeout
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
            // parse the token.
            String user = null;
            try{
                user = Jwts.parser() // แปลง token ที่รับมาจาก request ได้ค่า user.getId() ที่เราเก็บไว้
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace("Bearer", ""))//ไม่ต้องมีก็ได้เพราะไม่ใช้ Bearer 
                    .getBody()
                    .getSubject();
            }
            catch(JwtException jwtException){
                System.out.println(jwtException.getMessage());
            }
            

            return user != null
                    ? new UsernamePasswordAuthenticationToken(user, null, emptyList())
                    : // ถ้า user ไม่ใช่ null ให้ส่งค่า user ว่าผ่านได้
                    null;
        }
        return null;
    }

}
