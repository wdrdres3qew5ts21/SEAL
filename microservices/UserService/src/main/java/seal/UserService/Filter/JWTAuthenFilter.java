package seal.UserService.Filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.servlet.FilterConfig;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import seal.UserService.Exceptions.BadRequestException;

public class JWTAuthenFilter extends FilterSecurityInterceptor {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            TokenAuthenticationService.validateJWTAuthentication((HttpServletRequest) request);
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            chain.doFilter(request, response);
        } catch (io.jsonwebtoken.SignatureException signatureException) {
            throw new BadRequestException("JWT Token has been change we dont trust your token !");
        } catch (io.jsonwebtoken.ExpiredJwtException signExpiredJwtException) {
            throw new BadRequestException("JWT Token Is Already Timeout Please Login Again !");
        }

    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        super.init(arg0); //To change body of generated methods, choose Tools | Templates.
    }

}
