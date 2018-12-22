package seal.FileService.Filter;

import io.jsonwebtoken.Claims;
import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Jwts;
import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import seal.FileService.Exceptions.BadRequestException;
import static seal.FileService.Filter.GlobalValue.secretKey;

@Service
public class TokenAuthenticationService {

    public static Claims validateJWTAuthentication(HttpServletRequest request) {
        System.out.println(secretKey);
        String token = request.getHeader("Authorization");
        try {
            if (token != null) {
                try {
                    Claims user = (Claims) (Jwts.parser().setSigningKey(Base64.getEncoder()
                            .encodeToString(secretKey.getBytes("UTF-8")))
                            .parse(token).
                            getBody());
                    return user;
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
        return null;
    }

    public static void validateIsUserRoleTeacher(Claims user) {
        user.get("user", HashMap.class);
        HashMap userDetail = user.get("user", HashMap.class);
        System.out.println("user : " + userDetail.get("role"));
        if(!userDetail.get("role").toString().equals("teacher")){
            throw new BadRequestException("This user is not Teacher so not have enough permission !");
        }
    }
}
