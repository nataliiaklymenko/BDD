package bdd.utils.webdriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Created by argentum on 11.05.17.
 */
@Lazy
@Configuration
public class DriverFactory {
    private static Logger LOGGER = LogManager.getLogger();
    private static WebDriver driver;

    @Value("${browser}")
    private String browser;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }

    @Bean(name = "webDriver", destroyMethod = "quite")
    public WebDriver webDriver(){
        if(driver == null)
            try {
                driver = createNewDriverInstance();
            }
            catch (Exception ex){
                LOGGER.error("Webdriver initialization failed. " + ex.getMessage());
            }
            return driver;
    }

    private WebDriver createNewDriverInstance() throws Exception {
        switch (browser){
            case "ie":
                DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
                desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                desiredCapabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                desiredCapabilities.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, true);
return new InternetExplorerDriver(desiredCapabilities);
        default:
            LOGGER.error("Unknown browser." + browser);
            throw new Exception("Unknown browser. " + browser);
        }
    }

    public static void destroyDriver(){
        driver.quit();
        driver = null;
    }
}
