package de.marcusjanke.examples.spring.jaxrs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@AllArgsConstructor
public class Echo {

    @JsonProperty("id")
    private long id;
    @JsonProperty("content")
    private String content;
}