package oet.wouter.ci.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("service")
public class Service {

    private final String version = "1.0";

    @GET
    @Produces("text/plain")
    public String getData() {
        return "Application version: " + version + " on " + System.getProperty("environment");
    }
}
