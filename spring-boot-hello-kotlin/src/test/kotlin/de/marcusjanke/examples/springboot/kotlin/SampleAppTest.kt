package de.marcusjanke.examples.springboot.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus.OK
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
internal class SampleAppTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun shouldReturnHelloMessage() {
        val result = testRestTemplate.getForEntity("/", String::class.java)
        assertThat(result).isNotNull;
        assertThat(result.statusCode).isEqualTo(OK);
        assertThat(result.body).isEqualTo("This is your Kotlin sample app!")
    }
}