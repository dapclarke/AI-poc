package hellocucumber;

import io.cucumber.java.en.*;
//import static org.assertj.core.api.Assertions.assertThat;

// Add to import REST-assured libraries
//import io.restassured.response.Response;
//import static io.restassured.RestAssured.*;
//import static org.junit.Assert.*;



/*
class IsItFriday {
    static String isItFriday(String today) {
        // return null;
        // return "Nope";
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}
*/

/*
public class GreetingSteps {

    private Response response;

    @Given("the API is running")
    public void theApiIsRunning() {
        // Optional: health check or assume it's running
    }

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        response = get(endpoint);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response body should be {string}")
    public void theResponseBodyShouldBe(String expectedBody) {
        assertEquals(expectedBody, response.getBody().asString());
    }
}
*/

public class StepDefinitions {

    //private String today;
    ///private String actualAnswer;

    @Given("an example scenario")
    public void anExampleScenario() {
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
    }

}
