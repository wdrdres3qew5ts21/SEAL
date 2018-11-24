package seal.SubjectService.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class FilterConfig extends WebSecurityConfigurerAdapter {

    @Override // ส่วนของ กำหนด filter 
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
            .antMatchers("/").permitAll()
            //.anyRequest().authenticated()
            .and()
            .addFilterBefore(
                    new JWTGenericFilterBean(),
                    UsernamePasswordAuthenticationFilter.class
            );
    }
}