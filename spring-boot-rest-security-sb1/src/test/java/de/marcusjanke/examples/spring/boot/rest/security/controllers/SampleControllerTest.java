package de.marcusjanke.examples.spring.boot.rest.security.controllers;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import de.marcusjanke.examples.spring.boot.rest.security.SecurityConfig;

/**
 * 
 * @author marcus
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private SampleController sampleController;

	/**
	 * test that context was loaded
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(mockMvc).isNotNull();
		assertThat(sampleController).isNotNull();
	}

	@Test
	public void testNoAuthOk() throws Exception {
		assertThat(this.mockMvc.perform(get(SampleController.PATH_NO_AUTH)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString()).contains(SampleController.NO_AUTH_RESPONSE);
	}

	@Test
	public void testBasicAuthOk() throws Exception {
		assertThat(this.mockMvc.perform(get(SampleController.PATH_BASIC_AUTH).with(httpBasic(SecurityConfig.USER_NAME, SecurityConfig.PASSWORD))).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString()).contains(SampleController.BASIC_AUTH_RESPONSE);
	}

	@Test
	public void testBasicAuthUnauthorized() throws Exception {
		assertThat(this.mockMvc.perform(get(SampleController.PATH_BASIC_AUTH)).andExpect(status().isUnauthorized()).andReturn().getResponse().getContentAsString())
				.doesNotContain(SampleController.BASIC_AUTH_RESPONSE);
	}
}
