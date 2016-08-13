package tutorial.api.controllers;

import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import tutorial.ApplicationIntegrationTest;

import java.util.HashMap;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;

public class ProductControllerTest extends ApplicationIntegrationTest {

    private HashMap<String, Object> stubProduct1 = new HashMap<String,
            Object>() {{
        put("id", 1);
        put("name", "Macbook Air");
        put("price", 999.95F);
    }};

    private HashMap<String, Object> stubProduct2 = new HashMap<String,
            Object>() {{
        put("id", 2);
        put("name", "Magic Mouse");
        put("price", 69.95F);
    }};

    private HashMap<String, Object> stubProduct3 = new HashMap<String,
            Object>() {{
        put("id", 3);
        put("name", "Sunglasses");
        put("price", 14.50F);
    }};

    @Test
    public void showAll() throws Exception {
        Response response = get("/api/products");
        Assert.assertEquals(200, response.getStatusCode());

        String json = response.asString();

        HashMap<String, Object> product1 = from(json).get("[0]");

        for (String key : stubProduct1.keySet()) {
            Assert.assertTrue(product1.containsKey(key));
            Assert.assertEquals(product1.get(key), stubProduct1.get(key));
        }

        HashMap<String, Object> product2 = from(json).get("[1]");

        for (String key : stubProduct2.keySet()) {
            Assert.assertTrue(product2.containsKey(key));
            Assert.assertEquals(product2.get(key), stubProduct2.get(key));
        }
    }

    @Test
    public void show() throws Exception {
        Response response = get("/api/products/{productId}", 1);
        Assert.assertEquals(200, response.getStatusCode());
        String json = response.asString();

        HashMap<String, Object> product1 = from(json).get();

        for (String key : stubProduct1.keySet()) {
            Assert.assertTrue(product1.containsKey(key));
            Assert.assertEquals(product1.get(key), stubProduct1.get(key));
        }
    }

    @Test
    public void insert() throws Exception {
        Response insertResponse = given().parameters("name", stubProduct3.
                get("name"), "price", stubProduct3.get("price")).post("/api/products");
        Assert.assertEquals(200, insertResponse.getStatusCode());

        Response getResponse = get("/api/products/{productId}", 3);
        Assert.assertEquals(200, getResponse.getStatusCode());
        String json = getResponse.asString();

        HashMap<String, Object> product = from(json).get();

        for (String key : stubProduct3.keySet()) {
            Assert.assertTrue(product.containsKey(key));
            Assert.assertEquals(product.get(key), stubProduct3.get(key));
        }
    }

}
