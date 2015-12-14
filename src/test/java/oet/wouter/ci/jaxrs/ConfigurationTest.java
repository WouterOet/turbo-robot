package oet.wouter.ci.jaxrs;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import javax.ws.rs.ApplicationPath;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@Category(IntegrationTest.class)
public class ConfigurationTest {

    @Test
    public void testApplicationPath() throws Exception {
        ApplicationPath path = Configuration.class.getAnnotation(ApplicationPath.class);
        assertNotNull(path);
        assertThat(path.value(), is("api"));
    }
}