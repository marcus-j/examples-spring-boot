package de.marcusjanke.examples.spring.boot.hello;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyConfiguration.class)
public class MyConfigurationTest {
	
	@Autowired
	private MyBean myBean;

	@Test
	public void testMyConfiguration() {
		assertThat(myBean).isNotNull();
		assertThat(myBean.getName()).isNotNull().isEqualTo(MyConfiguration.NAME);
	}
    
}