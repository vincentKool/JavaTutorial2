package tutorial.api.controllers;

import org.junit.Assert;
import org.junit.Test;
import tutorial.ApplicationIntegrationTest;

import static com.jayway.restassured.RestAssured.get;

public class HomeControllerTest extends ApplicationIntegrationTest {

    @Test
    public void index() throws Exception {
        String result = get("/api/hello").asString();

        Assert.assertEquals("Hello Backend Server", result);
    }

}
