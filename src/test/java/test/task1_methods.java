package test;

import config.testConfig;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.*;

public class task1_methods extends testConfig {
    private final String products_endpoint = "products/{productID}";

    @Test
    public void addProduct(){
        // Target product
        String productJson = "{\n" +
                "    \"title\": \"iPhone 15 Pro\",\n" +
                "    \"description\": \"Experience the world in a different way\",\n" +
                "    \"price\": 1099,\n" +
                "    \"discountPercentage\": 12.96,\n" +
                "    \"rating\": 4.99,\n" +
                "    \"stock\": 1,\n" +
                "    \"brand\": \"Apple\",\n" +
                "    \"category\": \"Smartphones\",\n" +
                "    \"thumbnail\": \"iPhone-15-Test\",\n" +
                "    \"images\": \"https://media.gq.com.mx/photos/63569c49b430aa98c0db8988/16:9/w_2560%2Cc_limit/iphone%252014%2520pro%2520max.jpg\"\n" +
                "}";

        // Methods
        given()
                .body(productJson)
        .when()
                .post(products_endpoint, "add")
        .then().log().all();
    }
    @Test
    public void updateMethod(){
        // Target product
        String productID = "100";
        String updateProductJson = "{\n" +
                "    \"title\": \"Samsung Galaxy 23\",\n" +
                "    \"description\": \"A new form to experience the galaxy\",\n" +
                "    \"price\": 999,\n" +
                "    \"discountPercentage\": 15.99,\n" +
                "    \"rating\": 4.59,\n" +
                "    \"stock\": 37,\n" +
                "    \"brand\": \"Samsung\",\n" +
                "    \"category\": \"Smartphones\",\n" +
                "    \"thumbnail\": \"Samsung-Test\",\n" +
                "    \"images\": \"https://i.blogs.es/7a8b3a/s23/1366_2000.jpg\"\n" +
                "}";

        // Methods
        given()
                .body(updateProductJson)
        .when()
                .put(products_endpoint,productID)
        .then().log().all();
    }

    @Test
    public void deleteMethod(){
        // Target product
        String productID = "100";

        // Methods
        given()
        .when()
                .delete(products_endpoint, productID)
        .then().log().all();
    }

}
