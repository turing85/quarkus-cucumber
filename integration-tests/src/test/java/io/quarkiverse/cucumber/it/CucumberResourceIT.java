package io.quarkiverse.cucumber.it;

import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkiverse.cucumber.CucumberQuarkusIntegrationTest;
import io.quarkiverse.cucumber.it.actors.CucumberResourceActor;
import io.quarkiverse.cucumber.it.steps.CucumberResourceSteps;
import io.quarkus.test.component.QuarkusComponentTestExtension;

public class CucumberResourceIT extends CucumberQuarkusIntegrationTest {
    @RegisterExtension
    static final QuarkusComponentTestExtension COMPONENT_TEST_EXTENSION = new QuarkusComponentTestExtension(
            CucumberResourceSteps.class, CucumberResourceActor.class);

    public static void main(String... args) {
        runMain(CucumberResourceIT.class, args);
    }
}
