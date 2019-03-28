package de.marcusjanke.examples.springboot.primesfaces.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class InnerConfigTest {

    @TestConfiguration
    static class InnerTestConfig {

        @Bean
        public Duration timeout() {
            return Duration.ofSeconds(5);
        }
    }

    @Autowired
    private Duration timeout;

    @Test
    void shouldHaveFiveSecondTimeoutSet() {
        assertThat(timeout).isEqualByComparingTo(Duration.ofSeconds(5));
    }

}