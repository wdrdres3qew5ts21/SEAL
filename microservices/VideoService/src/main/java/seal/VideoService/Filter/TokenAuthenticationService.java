package seal.VideoService.Filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static java.util.Collections.emptyList;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import java.util.Base64;
import java.util.Date;
import seal.VideoService.Exceptions.BadRequestException;
import static seal.VideoService.Filter.GlobalValue.EXPIRATION_TIME;
import static seal.VideoService.Filter.GlobalValue.secretKey;

@Service
public class TokenAuthenticationService {

    public static Authentication validateJWTAuthentication(HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println(secretKey);
        String token = request.getHeader("Authorization");
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes("UTF-8")))
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();

            return user != null
                    ? new UsernamePasswordAuthenticationToken(user, null, emptyList())
                    : null;
        } else {
            throw new BadRequestException("Authorization Header is not found !");
        }
    }
}
