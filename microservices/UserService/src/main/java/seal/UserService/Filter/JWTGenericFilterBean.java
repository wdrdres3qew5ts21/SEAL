package seal.UserService.Filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import seal.UserService.User.TokenAuthenticationService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class JWTGenericFilterBean extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request); // รับค่าที่ส่งมา
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        SecurityContextHolder.getContext().setAuthentication(authentication); // ไอตัวนี้แหละที่หามานานไม่รู้คือไร 5555
        System.out.println();
        Enumeration<String> headers = httpRequest.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            System.out.println(header + " : " + httpRequest.getHeader(header));
        }
        chain.doFilter(request, response);
    }
}
