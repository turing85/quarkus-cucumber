package io.quarkiverse.cucumber.it.actors;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkiverse.cucumber.it.CucumberResource;
import io.restassured.response.ValidatableResponse;

@Unremovable
@ApplicationScoped
public class CucumberResourceActor {
    private final String greeting;

    private ValidatableResponse response;

    /**
     * Constructor for CDI to create proxy objects.
     */
    @SuppressWarnings("unused")
    CucumberResourceActor() {
        greeting = null;
    }

    @Inject
    @SuppressWarnings("unused")
    public CucumberResourceActor(@ConfigProperty(name = "greeting") String greeting) {
        System.out.println("constructor called");
        this.greeting = greeting;
    }

    public void callTarget() {
        response = when().get(CucumberResource.PATH)
                .then();
    }

    public void verifyResponse(int code) {
        verifyCode(code)
                .contentType(MediaType.TEXT_PLAIN)
                .body(is(greeting));
    }

    public ValidatableResponse verifyCode(int errorCode) {
        return response.statusCode(errorCode);
    }

    public void callNonExistingEndpoint() {
        response = when().get("does-not-exist")
            .then();
    }
}
