package hu.lamsoft.hms.common.restapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import hu.lamsoft.hms.common.restapi.security.jwt.JWTAuthenticationFilter;
import hu.lamsoft.hms.common.restapi.security.jwt.JWTLoginFilter;
import hu.lamsoft.hms.common.service.authentication.HMSUserDetailsService;

@Configuration
@EnableWebSecurity
public class HMSWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private HMSUserDetailsService hmsUserDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(hmsUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().cacheControl();

        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/secured/**/*").authenticated()
        .anyRequest().permitAll()
        .and()
        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.authenticationProvider(authenticationProvider());
    }

}
