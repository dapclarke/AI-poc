package com.example.restservice.greeting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingApiControllerTests {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        // Configure REST Assured to use the dynamic port
        baseURI = "http://dunc-rest-service-dctesttmp.azurewebsites.net";
        // baseURI = "http://localhost";
        port = this.port;
    }

    @Test
    public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenCorrect() {
        // Make a GET request to the greeting endpoint
        get("/greeting")
            .then()
                .statusCode(200)
                .assertThat()
                .body("content", equalTo("Hello, World!"));
    }
}
