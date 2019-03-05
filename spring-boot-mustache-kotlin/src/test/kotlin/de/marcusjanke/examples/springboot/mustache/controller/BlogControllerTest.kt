package de.marcusjanke.examples.springboot.mustache.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.net.URI

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class BlogControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    @DisplayName("Verifies a valid blog page title, heading and HTTP status code")
    fun shouldReturnValidBlogPage() {
        val entity = restTemplate.getForEntity<String>(URI.create("/blog"), String::class.java);
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK);
        assertThat(entity.body).contains("<h1>Blog</h1>");
        assertThat(entity.body).contains("<title>Blog</title>");
    }
}