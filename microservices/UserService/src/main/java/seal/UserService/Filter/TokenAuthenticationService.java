package seal.UserService.Filter;

import javax.servlet.http.HttpServletRequest;


import static java.util.Collections.emptyList;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                //.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes()))
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
        return token;
    }

    public static void validateJWTAuthentication(HttpServletRequest request) {
        System.out.println(secretKey);
        String token = request.getHeader("Authorization");
        try {
            if (token != null) {
                try {
                    String user = Jwts.parser()
                            .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes("UTF-8")))
                            .parseClaimsJws(token.replace("Bearer ", ""))
                            .getBody()
                            .getSubject();
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(TokenAuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                throw new BadRequestException("Authorization Header is not found !");
            }
        } catch (io.jsonwebtoken.SignatureException signatureException) {
            throw new BadRequestException("JWT Token has been change we dont trust your token !");
        } catch (io.jsonwebtoken.ExpiredJwtException signExpiredJwtException) {
            throw new BadRequestException("JWT Token Is Already Timeout Please Login Again !");
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
