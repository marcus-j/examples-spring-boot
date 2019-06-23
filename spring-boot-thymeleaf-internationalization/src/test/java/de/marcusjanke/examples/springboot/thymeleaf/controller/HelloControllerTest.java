package de.marcusjanke.examples.springboot.thymeleaf.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnDefaultGreeting() throws Exception {
        assertThat(this.mvc.perform(get("/hello?name=Sam"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString()).contains("Hello Sam");
    }

    @Test
    public void shouldReturnGermanGreeting() throws Exception {
        assertThat(this.mvc.perform(get("/hello?lang=de_DE&name=Claudia"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString()).contains("Hallo Claudia");
    }

    @Test
    public void shouldReturnFrenchGreeting() throws Exception {
        assertThat(this.mvc.perform(get("/hello?lang=fr_FR&name=Brigitte"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString()).contains("Salut Brigitte");
    }
}