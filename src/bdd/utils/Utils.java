package bdd.utils;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import bdd.utils.webdriver.DriverFactory;

/**
 * Created by argentum on 13.05.17.
 */
public class Utils {

    public static int DEFAULT_TIMEOUT = 10;

    public static boolean isWebElementClickable(WebDriver webDriver, WebElement element, int timeOut){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeOut);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }

    public static WebElement waitForWebElement(WebDriver webDriver, By locator, int timeOut){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeOut);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return webDriver.findElement(locator);
    }

    public static void waitForWebElement(WebDriver webDriver, WebElement element, int timeOut){
        waitForPageLoad(webDriver, timeOut);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeOut);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean waitWebElementIsDisplayed(WebDriver webDriver, WebElement element, int timeOut){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeOut);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public static void waitForExpectedNumberOfElements(WebDriver webDriver, By locator, int expectedNumberOfElements, int timeOut){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeOut);
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe(locator, expectedNumberOfElements));
    }

    public static void waitForPageLoad(WebDriver webDriver, int timeOut){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
        Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>() {
            public boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
            }
        };
        wait.until(pageLoaded);
    }

    public static void waitForElementValue(WebElement element, String attribute, String expectedValue, int defaultTimeout) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverFactory.getDriver(), defaultTimeout);
        webDriverWait.until(ExpectedConditions.attributeToBe(element, attribute, expectedValue));
    }
}
