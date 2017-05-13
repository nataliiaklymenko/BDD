package bdd.utils;

import cucumber.api.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import bdd.utils.webdriver.DriverFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by argentum on 13.05.17.
 */
public class ScenarioWrapper {
    private static Logger LOGGER = LogManager.getLogger();
private static Scenario SCENARIO;
    private SimpleDateFormat dr = new SimpleDateFormat("yyyy_MM_dd-HH-mm-ss");

    public static Scenario getSCENARIO() {
        return SCENARIO;
    }

    public ScenarioWrapper(WebDriver webDriver, Scenario scenario){
    SCENARIO = scenario;
}
public void saveScreenshot(String saveDirectoryPath){
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    FileOutputStream fileOutputStream;
    String pathToSaveFile = saveDirectoryPath + SCENARIO.getName() + " " + dr.format(timestamp) + ".jpg";

    byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);

    try {
        fileOutputStream = new FileOutputStream(pathToSaveFile);
        fileOutputStream.write(screenshot);
        fileOutputStream.close();
        LOGGER.error("Screenshot was saved. " + pathToSaveFile);
    } catch (FileNotFoundException e) {
        LOGGER.error("File not found.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
