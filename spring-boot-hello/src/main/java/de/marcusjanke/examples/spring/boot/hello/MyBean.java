package de.marcusjanke.examples.spring.boot.hello;

public class MyBean {

	private final String name;

	public MyBean(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
