package bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by argentum on 13.05.17.
 */
public class WHHomePage extends BasePage {

    @FindBy(xpath = "//a[@title='football']")
    private WebElement footballNavigationItem;

    private String eventTypeNavigationSelector = "//";

    public WHHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectEventType(String eventType) {
        clickOnElement(getDriver().findElement(By.xpath(eventType.replace("#", eventType))));
    }

    public void placeBet() {

    }
}
