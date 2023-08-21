package config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.BeforeClass;

public class testConfig {
    @BeforeClass
    public static void setup(){
        // Request
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://dummyjson.com/")
                .setContentType("application/json")
                .addHeader("Accept", "application/json")
                .build();

        // Response
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

}