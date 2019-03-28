package de.marcusjanke.examples.springboot.primesfaces.domain;

import lombok.Data;
import javax.inject.Named;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Named
@Data
public class User {

    private String firstName = EMPTY;
    private String lastName = EMPTY;

    public String sayHi() {
        return "Hi " + firstName + " " + lastName + "!";
    }
}