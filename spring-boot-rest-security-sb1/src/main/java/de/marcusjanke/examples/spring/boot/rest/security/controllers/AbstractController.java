package de.marcusjanke.examples.spring.boot.rest.security.controllers;

/**
 * 
 * @author marcus
 *
 */
public abstract class AbstractController {

	public static final String PATH_NO_AUTH = "/no-auth/resource";
	public static final String PATH_BASIC_AUTH = "/basic-auth/resource";
	public static final String PATH_OAUTH2 = "/oauth2/resource";

}
