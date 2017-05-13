package bdd.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import bdd.utils.ScenarioWrapper;
import bdd.utils.webdriver.DriverFactory;

/**
 * Created by argentum on 13.05.17.
 */
@PropertySource(name = "main", value = "${ENV}.properties")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CommonSteps {
    private static Logger LOGGER = LogManager.getLogger();
    ScenarioWrapper scenarioWrapper;

    @Autowired
    private Environment env;

    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        LOGGER.info(scenario.getName());
        scenarioWrapper = new ScenarioWrapper(DriverFactory.getDriver(), scenario);
        String envrironemnt = System.getenv("ENV");
        if(StringUtils.isNotBlank(envrironemnt)){
            DriverFactory.getDriver().get(env.getProperty("url"));
        }
        else {
            LOGGER.error("environment is not defined");
            throw new Exception("environment is not defined");
        }
    }
    @After
    public void afterScenario(){
        if(ScenarioWrapper.getSCENARIO().isFailed()){
            LOGGER.error("scenario failed");
            scenarioWrapper.saveScreenshot("screenshots/");
        }
    }

    @AfterClass
    public void afterFeature(){
        DriverFactory.destroyDriver();
        LOGGER.info("Feature resources.bdd.features were run");
    }

}
