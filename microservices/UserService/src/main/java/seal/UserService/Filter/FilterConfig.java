package seal.UserService.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class FilterConfig extends WebSecurityConfigurerAdapter {
    
    @Configuration
    @Order(1)
    public static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            System.out.println("Order 1 ");
            http.csrf().disable().authorizeRequests()
                    //                .antMatchers("/").permitAll()
                    .antMatchers(HttpMethod.POST, "/user/login")
                    .permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .addFilterBefore(new JWTGenericFilterBean(),UsernamePasswordAuthenticationFilter.class);
        }

    }

//    @Configuration
//    @Order(2)
//    public static class AnotherSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            System.out.println("Order 2");
//            http.csrf().disable().authorizeRequests().anyRequest().authenticated()
//                    .and()
//                    .addFilterBefore(new JWTGenericFilterBean(), UsernamePasswordAuthenticationFilter.class);
//                    
//        }
//
//    }

}
