package oet.wouter.ci.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("service")
public class Service {

    private static final String version = "2.0";

    @GET
    @Produces("text/plain")
    public String getData() {
        String environment = System.getenv("environment");
        return "Application version: " + version + " on " + environment;
    }
}
