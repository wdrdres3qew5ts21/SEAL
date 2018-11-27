package seal.UserService.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static java.util.Collections.emptyList;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;

import java.util.Base64;
import java.util.Date;

@Service
public class TokenAuthenticationService {

    public static long EXPIRATION_TIME = 1000 * 300000; // 30 seconds timeout
    
    //@Value("${authenservice.jwt.secret}")
    private static String secretKey = "sealsecret";
    
     //static Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
     

    //    @PostConstruct
    //    protected void init() {
    //        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    //    }

    public String createTokenUser(User user) {
        System.out.println("*****************************************************************************");
        System.out.println(secretKey);
        Date now = new Date();
        HashMap<String, Object> userJson = new HashMap<>();
        userJson.put("userId", user.getId());
        userJson.put("userImg", user.getImage());
        userJson.put("userName", user.getFirstname());

        String token = Jwts.builder()
                .claim("user", userJson)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,Base64.getEncoder().encodeToString(secretKey.getBytes()))
                .compact();
        return token;
    }

        public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        System.out.println("Get Authentication : " + token);
        System.out.println("==================================================================================================================="); 
        System.out.println(secretKey);
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes()))
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();

             return user != null
                     ? new UsernamePasswordAuthenticationToken(user, null, emptyList())
                     : null;
        }
        return null;
    }
 
//    public static Authentication getAuthentication(HttpServletRequest request) {
//        String token = request.getHeader("Authorization");
//        System.out.println("Get Authentication : " + token);
//        if (token != null) {
//            // parse the token.
//            String user = null;
//            // ถ้าเอา Try Catch ออกมันจะบึ้มแล้ว ใชช้สิทธิต่างๆไมไ่ด้
//            try {
//                user = Jwts.parser() // แปลง token ที่รับมาจาก request ได้ค่า user.getId() ที่เราเก็บไว้
//                        .setSigningKey(SECRET_KEY)
//                        .parseClaimsJws(token.replace("Bearer", ""))//ไม่ต้องมีก็ได้เพราะไม่ใช้ Bearer 
//                        .getBody()
//                        .getSubject();
//            } catch (JwtException jwtException) {
//                System.out.println("!!! Exception /: " + jwtException.getMessage());
//                System.out.println(user);
//                return null;
//
//            }
//
//            return user != null
//                    ? new UsernamePasswordAuthenticationToken(user, null, emptyList())
//                    : // ถ้า user ไม่ใช่ null ให้ส่งค่า user ว่าผ่านได้
//                    null;
//        }
//        return null;
//    }

}
