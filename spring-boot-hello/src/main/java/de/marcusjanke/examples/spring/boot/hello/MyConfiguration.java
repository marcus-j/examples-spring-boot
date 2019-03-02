package de.marcusjanke.examples.spring.boot.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	static final String NAME = "Dude";

	@Bean
	public MyBean myBean() {
		return new MyBean(NAME);
	}
}
