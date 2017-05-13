package bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import bdd.utils.Utils;
import bdd.utils.webdriver.DriverFactory;

/**
 * Created by argentum on 11.05.17.
 */
public class BasePage extends DriverFactory {

    public BasePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    protected void openPage(String url){
        getDriver().get(url);
    }

    protected WebElement finElementByText(String path, String text){
        return getDriver().findElement(By.xpath(path.replace("#", text)));
    }

    protected void scrollPage(){
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
        javaScriptExecutor.executeScript("window.scrollBy(0, 500)");
    }

    protected void inputValueToField(WebElement field, String value){
        Utils.waitForWebElement(getDriver(), field, Utils.DEFAULT_TIMEOUT);
        field.clear();
        field.sendKeys(value);
        Utils.waitForPageLoad(getDriver(), Utils.DEFAULT_TIMEOUT);
    }

    protected void clickOnElement(WebElement element){
        Utils.waitWebElementIsDisplayed(getDriver(), element, Utils.DEFAULT_TIMEOUT);
        element.click();
        Utils.waitForPageLoad(getDriver(), Utils.DEFAULT_TIMEOUT);
    }

    protected void clickOnElementWithJavaScript(WebElement element){
       Utils.isWebElementClickable(getDriver(), element, Utils.DEFAULT_TIMEOUT);
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", element);
    }

    protected boolean verifyElemenetAttribute(WebElement element, String attribute, String expectedValue){
        try {
            Utils.waitForElementValue(element, attribute, expectedValue, Utils.DEFAULT_TIMEOUT);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
