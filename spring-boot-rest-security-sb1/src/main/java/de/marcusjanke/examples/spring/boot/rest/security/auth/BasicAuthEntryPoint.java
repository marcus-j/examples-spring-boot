package de.marcusjanke.examples.spring.boot.rest.security.auth;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * BasicAuthEntryPoint, override parent methods as needed
 * 
 * @author marcus
 *
 */
@Component
public class BasicAuthEntryPoint extends BasicAuthenticationEntryPoint {
	
	private static final String REALM_NAME = "BasicAuthRealm";

	/**
	 * Create new BasicAuthEntryPoint
	 */
	public BasicAuthEntryPoint() {
		super();
		setRealmName(REALM_NAME);
	}

}