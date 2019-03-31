package de.marcusjanke.examples.spring.webflux.controllers;

import de.marcusjanke.examples.spring.webflux.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static java.util.stream.IntStream.rangeClosed;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void shouldGetUserById() {
        User expected = new User(1, "John", "Doe");
        webTestClient.get().uri("/users/1")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody(User.class)
                .isEqualTo(expected);
    }

    @Test
    public void shouldGetAllUsers() {
        User[] expected = rangeClosed(1, 10)
                .boxed()
                .map(id -> new User(id, "John", "Doe")).toArray(User[]::new);
        webTestClient.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(User.class)
                .contains(expected);
    }
}