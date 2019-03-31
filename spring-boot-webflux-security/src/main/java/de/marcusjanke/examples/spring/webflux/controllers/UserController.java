package de.marcusjanke.examples.spring.webflux.controllers;

import de.marcusjanke.examples.spring.webflux.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.stream.IntStream.rangeClosed;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    private Mono<User> getUserById(@PathVariable long id) {
        User user = new User(id, "John", "Doe");
        return Mono.just(user);
    }

    @GetMapping
    private Flux<User> getAllUsers() {
        return Flux.fromStream(
                rangeClosed(1, 10)
                        .boxed()
                        .map(id -> new User(id, "John", "Doe"))
        );
    }
}
