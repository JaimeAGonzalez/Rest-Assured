package test;

import config.testConfig;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class task3_schema extends testConfig {
    private final String products_endpoint = "products/{productID}";

    @Test
    public void addProduct() {
        String productJson = "{\n" +
                "    \"title\": \"iPhone 15 Pro\",\n" +
                "    \"description\": \"Experience the world in a different way\",\n" +
                "    \"price\": 1099,\n" +
                "    \"rating\": 4.99,\n" +
                "    \"stock\": 1,\n" +
                "    \"brand\": \"Apple\",\n" +
                "    \"category\": \"Smartphones\",\n" +
                "    \"discountPercentage\": 12.99,\n" +
                "    \"thumbnail\": \"iPhone-15-Test\",\n" +
                "    \"images\": \"https://media.gq.com.mx/photos/63569c49b430aa98c0db8988/16:9/w_2560%2Cc_limit/iphone%252014%2520pro%2520max.jpg\"\n" +
                "}";

        given()
                .body(productJson)
        .when()
                .post(products_endpoint, "add")
        .then().log().all()
                .statusCode(Matchers.equalTo(200)) // Status code
                .time(Matchers.lessThan(2000L)) //Response
                .header("Content-Type", "application/json; charset=utf-8") // Headers
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("./package.json")); //Json validator
    }
}
