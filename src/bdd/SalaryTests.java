package bdd;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by argentum on 11.05.17.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/bdd/features/scenario3.feature",
        strict = true
)
public class SalaryTests {
}
