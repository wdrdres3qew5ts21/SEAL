package seal.VideoService.Filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

import java.util.Base64;
import static java.util.Collections.emptyList;
import static seal.VideoService.Filter.GlobalValue.secretKey;

@Service
public class TokenAuthenticationService {

    public static Authentication getAuthentication(HttpServletRequest request) {
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
        }
        return null;
    }

}
