package seal.SubjectService.Filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;
import seal.SubjectService.Exceptions.BadRequestException;
//@Configuration
public class JWTAuthenFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            System.out.println("Authorixzation : " + httpRequest.getHeader("Authorization"));
            TokenAuthenticationService.validateJWTAuthentication((HttpServletRequest) request);
            chain.doFilter(request, response);
        } catch (io.jsonwebtoken.SignatureException signatureException) {
            throw new BadRequestException("JWT Token has been change we dont trust your token !");
        } catch (io.jsonwebtoken.ExpiredJwtException signExpiredJwtException) {
            throw new BadRequestException("JWT Token Is Already Timeout Please Login Again !");
        }

    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            System.out.println("wtf 24 is work");
//            System.out.println("FUUUU: " + request.getHeader("Authorization"));
//            Enumeration<String> header = request.getHeaderNames();
//            while (header.hasMoreElements()) {
//                String nextElement = header.nextElement();
//                System.out.println(nextElement + " : '" + request.getHeader(nextElement));
//
//            }
////            Authentication authentication = 
//            TokenAuthenticationService.validateJWTAuthentication((HttpServletRequest) request);
//            HttpServletRequest httpRequest = (HttpServletRequest) request;
//            //SecurityContextHolder.getContext().setAuthentication(authentication);
//            filterChain.doFilter(request, response);
//        } catch (io.jsonwebtoken.SignatureException signatureException) {
//            throw new BadRequestException("JWT Token has been change we dont trust your token !");
//        } catch (io.jsonwebtoken.ExpiredJwtException signExpiredJwtException) {
//            throw new BadRequestException("JWT Token Is Already Timeout Please Login Again !");
//        }
//
//    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
