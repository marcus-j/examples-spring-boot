package de.marcusjanke.examples.spring.jaxrs.resources;

import de.marcusjanke.examples.spring.jaxrs.domain.Echo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

import static java.lang.String.format;

@Path("echo")
@Produces(MediaType.APPLICATION_JSON)
public class EchoResource {

    @Path("{name}")
    @GET
    public Echo getEcho(@PathParam("name") String name) {
        return new Echo(new Random().nextLong(), format("Hi, %s!", name));
    }
}
