package test;

import config.testConfig;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class task2_assertions extends testConfig {
    private final String products_endpoint = "products/{productID}";

    @Test
    public void addProduct(){
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

        given()
                .body(productJson)
        .when()
                .post(products_endpoint, "add")
        .then().log().all()
                .statusCode(Matchers.equalTo(200)) // Status code
                .time(Matchers.lessThan(2000L)) //Response
                .header("Content-Type", "application/json; charset=utf-8") // Headers
                .contentType(ContentType.JSON)
                .body("id", Matchers.equalTo(101)) // Data fields
                .body("title", Matchers.startsWith("iPhone"))
                .body("price", Matchers.equalTo(1099))
                .body("stock", Matchers.equalTo(1))
                .body("rating", Matchers.equalTo(4.99f))
                .body("thumbnail", Matchers.equalTo("iPhone-15-Test"))
                .body("description", Matchers.startsWith("Experience the"))
                .body("brand", Matchers.equalTo("Apple"))
                .body("category", Matchers.equalTo("Smartphones"));
    }
    @Test
    public void updateMethod(){
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

        given()
                .body(updateProductJson)
        .when()
                .put(products_endpoint,productID)
        .then().log().all()
                .statusCode(Matchers.equalTo(200)) // Status code
                .time(Matchers.lessThan(2000L)) // Response time
                .headers("Content-Type", "application/json; charset=utf-8") // Headers
                .contentType(ContentType.JSON)
                .body("id", Matchers.equalTo(100)) // Data fields
                .body("title", Matchers.startsWith("Samsung"))
                .body("price", Matchers.equalTo(999))
                .body("stock", Matchers.equalTo(37))
                .body("rating", Matchers.equalTo(4.59f))
                .body("thumbnail", Matchers.equalTo("Samsung-Test"))
                .body("description", Matchers.startsWith("A new form"))
                .body("brand", Matchers.equalTo("Samsung"))
                .body("category", Matchers.equalTo("Smartphones"));
    }

    @Test
    public void deleteMethod(){
        String productID = "100";

        given()

        .when()
                .delete(products_endpoint, productID)
        .then().log().all()
                .statusCode(Matchers.equalTo(200)) // Status code
                .time(Matchers.lessThan(2000L)) // Response time
                .contentType(ContentType.JSON) // Headers
                .body("isDeleted", Matchers.equalTo(true))
                .body("deletedOn", Matchers.startsWith(ZonedDateTime.now(ZoneOffset.UTC)
                        .format(DateTimeFormatter.ISO_LOCAL_DATE)));
    }
}
