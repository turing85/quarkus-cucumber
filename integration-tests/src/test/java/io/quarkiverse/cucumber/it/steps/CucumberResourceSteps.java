package io.quarkiverse.cucumber.it.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.quarkiverse.cucumber.it.actors.CucumberResourceActor;
import io.quarkus.arc.Unremovable;
import jakarta.inject.Singleton;
import jakarta.ws.rs.core.Response;

@Unremovable
@Singleton
public class CucumberResourceSteps {
    private final CucumberResourceActor actor;

    public CucumberResourceSteps(CucumberResourceActor actor) {
        this.actor = actor;
    }

    @Given("^print \"(.+)\"$")
    public void print(String message) {
        System.out.println(message);
    }

    @Given("I call the endpoint")
    public void i_call_endpoint() {
        actor.callTarget();
    }

    @Then("the response is ok")
    public void response_is_ok() {
        actor.verifyResponse(Response.Status.OK.getStatusCode());
    }

    @Given("I call a non-existing endpoint")
    public void i_call_a_non_existing_endpoint() {
        actor.callNonExistingEndpoint();
    }

    @Then("I get an error")
    public void i_get_an_error() {
        actor.verifyCode(Response.Status.NOT_FOUND.getStatusCode());
    }
}
