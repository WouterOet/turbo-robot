package oet.wouter.ci.jaxrs;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Category(IntegrationTest.class)
public class ServiceIT {

    @Test
    public void testService() throws Exception {
        URI uri = UriBuilder.fromUri("http://{host}:{port}/ci-testing/api/service").build(System.getProperty("testHost"), System.getProperty("testPort"));
        Response response = ClientBuilder.newClient().target(uri).request().get();

        assertThat(response.getStatus(), is(200));
        String result = response.readEntity(String.class);
        assertTrue(result.startsWith("Application version:"));

        Thread.sleep(TimeUnit.MINUTES.toMicros(5));
    }
}