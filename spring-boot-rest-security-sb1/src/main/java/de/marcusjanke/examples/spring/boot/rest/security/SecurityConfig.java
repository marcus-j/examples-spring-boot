package de.marcusjanke.examples.spring.boot.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import de.marcusjanke.examples.spring.boot.rest.security.auth.BasicAuthEntryPoint;
import de.marcusjanke.examples.spring.boot.rest.security.controllers.AbstractController;

/**
 * securtiy config for resource endpoints
 * 
 * @author marcus
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String USER_NAME = "john";
	public static final String PASSWORD = "password123";
	public static final String USER_ROLE = "USER";

	@Autowired
	private BasicAuthEntryPoint basicAuthEntryPoint;

	/**
	 * Configure different auth methods (or none) for different resources
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher(AbstractController.PATH_NO_AUTH).authorizeRequests().anyRequest().permitAll().and()
			.antMatcher(AbstractController.PATH_BASIC_AUTH).authorizeRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(basicAuthEntryPoint);
	}

	/**
	 * set up in-memory users
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(USER_NAME).password(PASSWORD).roles(USER_ROLE);
	}
}
