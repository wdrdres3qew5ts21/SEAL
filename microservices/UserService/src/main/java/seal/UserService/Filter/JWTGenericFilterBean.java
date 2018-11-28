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
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

//@Order(1)
//@Component
//@WebFilter(urlPatterns = "/user/login")
public class JWTGenericFilterBean extends FilterSecurityInterceptor{

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        super.init(arg0); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Inw ZA 23");
        Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request);
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Inw ZA 1");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Enumeration<String> headers = httpRequest.getHeaderNames();
        System.out.println("Inw ZA 2");
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            System.out.println(header + " : " + httpRequest.getHeader(header));
        }
        if (httpRequest.getHeader("authorization") != null) {
            System.out.println("authorization is null");
            chain.doFilter(request, response);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not jwt");
        }

    }
    
}
