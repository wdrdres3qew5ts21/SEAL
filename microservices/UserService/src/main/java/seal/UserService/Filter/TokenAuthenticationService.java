package seal.UserService.Filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static java.util.Collections.emptyList;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import java.util.Base64;
import java.util.Date;
import seal.UserService.Exceptions.BadRequestException;
import seal.UserService.User.User;
import static seal.UserService.Filter.GlobalValue.EXPIRATION_TIME;
import static seal.UserService.Filter.GlobalValue.secretKey;

@Service
public class TokenAuthenticationService {

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
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes()))
                .compact();
        return token;
    }

    public static Authentication validateJWTAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes()))
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();

            return user != null
                    ? new UsernamePasswordAuthenticationToken(user, null, emptyList())
                    : null;
        }else{
            throw new BadRequestException("Authorization Header is not found !");
        }
    }

//    public static Authentication validateJWTAuthentication(HttpServletRequest request) {
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
