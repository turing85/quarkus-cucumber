package io.quarkiverse.cucumber.it.options;

import io.quarkiverse.cucumber.it.actors.CucumberResourceActor;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkiverse.cucumber.CucumberOptions;
import io.quarkiverse.cucumber.CucumberQuarkusIntegrationTest;
import io.quarkiverse.cucumber.it.steps.CucumberResourceSteps;
import io.quarkus.test.component.QuarkusComponentTestExtension;

@CucumberOptions(glue = { "io.quarkiverse.cucumber.it.steps" }, tags = "@important", plugin = { "json" })
public class CucumberOptionsIT extends CucumberQuarkusIntegrationTest {
    @RegisterExtension
    static final QuarkusComponentTestExtension COMPONENT_TEST_EXTENSION = new QuarkusComponentTestExtension(
            CucumberResourceSteps.class, CucumberResourceActor.class);

    public static void main(String... args) {
        runMain(CucumberOptionsIT.class, args);
    }
}
