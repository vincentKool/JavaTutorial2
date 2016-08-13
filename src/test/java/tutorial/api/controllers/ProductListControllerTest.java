package tutorial.api.controllers;

import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import tutorial.ApplicationIntegrationTest;

import java.util.ArrayList;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;

public class ProductListControllerTest  extends ApplicationIntegrationTest {

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

    private HashMap<String, Object> stubProductList1 = new HashMap<String,
    Object>() {{
        put("id", 1);
        put("name", "Boodschappen");
        put("products", new ArrayList<HashMap>() {{
            add(stubProduct1);
        }});
    }};

    private HashMap<String, Object> stubProductList2 = new HashMap<String,
            Object>() {{
        put("id", 2);
        put("name", "Tech");
        put("products", new ArrayList<HashMap>());
    }};

    private HashMap<String, Object> stubProductList3 = new HashMap<String,
            Object>() {{
        put("id", 3);
        put("name", "Wishlist");
        put("products", new ArrayList<HashMap>());
    }};

    private HashMap<String, Object> stubProductList3_filled = new HashMap<String,
            Object>() {{
        put("id", 3);
        put("name", "Wishlist");
        put("products", new ArrayList<HashMap>() {{
            add(stubProduct2);
        }});
    }};



    @Test
    public void showAll() throws Exception {
        Response response = get("/api/lists");
        Assert.assertEquals(200, response.getStatusCode());

        String json = response.asString();

        HashMap<String, Object> productList1 = from(json).get("[0]");

        for (String key : stubProductList1.keySet()) {
            Assert.assertTrue(productList1.containsKey(key));
            Assert.assertEquals(productList1.get(key), stubProductList1.get(key));
        }

        HashMap<String, Object> productList2 = from(json).get("[1]");

        for (String key : stubProductList2.keySet()) {
            Assert.assertTrue(productList2.containsKey(key));
            Assert.assertEquals(productList2.get(key), stubProductList2.get(key));
        }
    }

    @Test
    public void show() throws Exception {
        Response response = get("/api/lists/{productListId}", 1);
        Assert.assertEquals(200, response.getStatusCode());
        String json = response.asString();

        HashMap<String, Object> productList1 = from(json).get();

        for (String key : stubProductList1.keySet()) {
            Assert.assertTrue(productList1.containsKey(key));
            Assert.assertEquals(productList1.get(key), stubProductList1.get(key));
        }
    }

    @Test
    public void insert() throws Exception {
        Response insertResponse = given().parameters("name", stubProductList3.get("name")).post("/api/lists");
        Assert.assertEquals(200, insertResponse.getStatusCode());

        Response getResponse = get("/api/lists/{productListId}", 3);
        Assert.assertEquals(200, getResponse.getStatusCode());
        String json = getResponse.asString();

        HashMap<String, Object> product = from(json).get();

        for (String key : stubProductList3.keySet()) {
            Assert.assertTrue(product.containsKey(key));
            Assert.assertEquals(product.get(key), stubProductList3.get(key));
        }
    }

    @Test
    public void addProduct() {
        stubProductList2.put("products", new ArrayList<HashMap>() {{
            add(stubProduct2);
        }});

        Response insertResponse = given()
                .parameters("ListId", stubProductList2.get("id"),
                            "productId", stubProduct2.get("id"))
                .post("/api/lists/{listId}/products", stubProductList2.get("id"));
        Assert.assertEquals(200, insertResponse.getStatusCode());

        Response getResponse = get("/api/lists/{productListId}", stubProductList2.get("id"));
        Assert.assertEquals(200, getResponse.getStatusCode());
        String json = getResponse.asString();

        HashMap<String, Object> product = from(json).get();

        for (String key : stubProductList2.keySet()) {
            Assert.assertTrue(product.containsKey(key));
            Assert.assertEquals(product.get(key), stubProductList2.get(key));
        }
    }
}
