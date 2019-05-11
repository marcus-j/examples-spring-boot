package de.marcusjanke.examples.springrest.controller;

import de.marcusjanke.examples.springrest.domain.User;
import de.marcusjanke.examples.springrest.repo.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() {
        userRepository.save(new User("John"));
    }

    @Test
    public void shouldLoadUserFromRepoBasedOnUserIdQueryParameter() {
        assertThat(this.restTemplate.getForEntity("http://localhost:" + port + "/users/1",
                User.class).getBody()).isEqualTo(new User(1, "John"));
    }
}