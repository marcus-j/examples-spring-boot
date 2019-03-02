package de.marcusjanke.examples.spring.boot.hello;

class MyBean {

	private final String name;

	MyBean(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}
}
