package io.quarkiverse.cucumber.test;

import static io.restassured.RestAssured.given;

import jakarta.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;

public class Steps {

    @Inject
    @ConfigProperty(defaultValue = "/")
    String target;

    private ValidatableResponse result;

    @Given("I call the endpoint")
    public void i_call_endpoint() throws Exception {
        result = given()
                .when().get(target)
                .then();
    }

    @Then("the response is ok")
    public void response_is_ok() throws Exception {
        result.statusCode(200);
    }

}
