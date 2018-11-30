/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.SubjectService.Filter;

import java.util.ArrayList;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author top
 */
//@Configuration
public class FilterConfiguration {

   // @Bean
    public FilterRegistrationBean<JWTAuthenFilter> jwtAuthenticationFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JWTAuthenFilter());
        ArrayList<String> urlPath = new ArrayList();
        urlPath.add("/programs");
        urlPath.add("/program/*");
        filterRegistrationBean.setUrlPatterns(urlPath);
        return filterRegistrationBean;
    }

}
