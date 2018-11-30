package seal.VideoService.Filter;

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
import seal.VideoService.Exceptions.BadRequestException;
import static seal.VideoService.Filter.GlobalValue.EXPIRATION_TIME;
import static seal.VideoService.Filter.GlobalValue.secretKey;

@Service
public class TokenAuthenticationService {

    public static void validateJWTAuthentication(HttpServletRequest request) {
        System.out.println("validateJWTAuthenitcate : "+ secretKey);
        String token = request.getHeader("Authorization");
        try {
            if (token != null) {
                String user = Jwts.parser()
                        .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes("UTF-8")))
                        .parseClaimsJws(token.replace("Bearer ", ""))
                        .getBody()
                        .getSubject();

            } else {
                throw new BadRequestException("Authorization Header is not found !");
            }
        } catch (io.jsonwebtoken.SignatureException signatureException) {
            throw new BadRequestException("JWT Token has been change we dont trust your token !");
        } catch (io.jsonwebtoken.ExpiredJwtException signExpiredJwtException) {
            throw new BadRequestException("JWT Token Is Already Timeout Please Login Again !");
        } catch (UnsupportedEncodingException ex) {
            //Logger.getLogger(TokenAuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex : " + ex.getMessage());
        }
    }
}
