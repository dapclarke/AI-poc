package com.exampleapi.restservice.greeting;
// package com.example.api.greetingapi; // Gen by AI

import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

//import static io.restassured.RestAssured.given; // Gen by AI
import static org.hamcrest.Matchers.*;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingApiControllerTests {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        // Get the base URL from system properties or use default
        String appBaseUrl = System.getProperty("APP_BASE_URL", "http://localhost:8080");
        baseURI = appBaseUrl;
        // Don't set port when using full URL
        port = 80;
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

    // @BeforeEach
    // public void setUp() {
    //     RestAssured.port = port;
    // }

    // @Test
    // public void shouldReturnDefaultGreeting() {
    //     given()
    //         .when()
    //             .get("/api/greeting")
    //         .then()
    //             .statusCode(200)
    //             .body("message", is("Hello, World!"));
    // }

    // @Test
    // public void shouldReturnCustomGreeting() {
    //     String name = "John";
        
    //     given()
    //         .when()
    //             .get("/api/greeting?name=" + name)
    //         .then()
    //             .statusCode(200)
    //             .body("message", is("Hello, " + name + "!"));
    // }

}
