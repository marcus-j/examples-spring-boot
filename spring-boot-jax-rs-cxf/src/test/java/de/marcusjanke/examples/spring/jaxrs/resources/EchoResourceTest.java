package de.marcusjanke.examples.spring.jaxrs.resources;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EchoResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldEchoName() throws JSONException {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/api/echo/Bob",
                String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        JSONAssert.assertEquals("{\"content\":\"Hi, Bob!\"}", entity.getBody(), JSONCompareMode.LENIENT);
    }
}