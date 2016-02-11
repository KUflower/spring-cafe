package scafe.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import scafe.domain.utils.ScafeUserDetailsService;


//@Component

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
	        .formLogin()
	              .usernameParameter("email")
                    .loginPage("/user/login")
                    .defaultSuccessUrl("/board")
                //Configures the logout function
                .and()
                    .logout()
                        .logoutUrl("/user/logout")
                        .logoutSuccessUrl("/")
                //Configures url based authorization
                .and()
                    .authorizeRequests()
                    	.antMatchers("/admin/**").hasRole("ADMIN")
                    	.antMatchers("/**/write*", "/**/edit*", "/**/delete*", "/upgrade/**").access("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
                    	.antMatchers(
                    			"/**", "/board/post/**"
                        ).permitAll();
                        //The rest of the our application is protected.

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		  web
          //Spring Security ignores request to static resources such as CSS or JS files.
          .ignoring()
              .antMatchers("/static/**");
	}
	
	 /**
     * Configures the authentication manager bean which processes authentication
     * requests.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    /**
     * This is used to hash the password of the user.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    /**
     * This bean is load the user specific data when form login is used.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new ScafeUserDetailsService();
    }

}
