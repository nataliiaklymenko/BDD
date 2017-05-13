package bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by argentum on 13.05.17.
 */
public class ReportPage extends BasePage {

    @FindBy(xpath = "")
    private WebElement button;

    public ReportPage(WebDriver webDriver) {
        super(webDriver);
    }
}
