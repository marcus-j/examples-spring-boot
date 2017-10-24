package de.marcusjanke.examples.spring.boot.rest.security.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * sample controller
 * 
 * @author marcus
 *
 */
@Controller
public class SampleController extends AbstractController {

	public static final String BASIC_AUTH_RESPONSE = "You're basically authenticated!";
	public static final String NO_AUTH_RESPONSE = "You're just in!";

	/**
	 * unsecured resource
	 * 
	 * @return
	 */
	@RequestMapping(path = PATH_NO_AUTH, method = RequestMethod.GET)
	public ResponseEntity<String> requestNoAuthResource() {
		return new ResponseEntity<String>(NO_AUTH_RESPONSE, HttpStatus.OK);
	}

	/**
	 * basic auth secured resource
	 * 
	 * @return
	 */
	@RequestMapping(path = PATH_BASIC_AUTH, method = RequestMethod.GET)
	public ResponseEntity<String> requestBasicAuthResource() {
		return new ResponseEntity<String>(BASIC_AUTH_RESPONSE, HttpStatus.OK);
	}
}
