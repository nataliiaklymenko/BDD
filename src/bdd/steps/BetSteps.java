package bdd.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import bdd.pages.WHHomePage;
import bdd.utils.webdriver.DriverFactory;

/**
 * Created by argentum on 13.05.17.
 */
public class BetSteps {
    private WHHomePage whHomePage;

    @Given("^User navigates to \"(.*)\"")
    public void navigateToPageByUrl(String url){
        DriverFactory.getDriver().get(url);
    }

    @And("^User navigate to \"(.*)\" type event$")
    public void selectEventType(String eventType){
        whHomePage.selectEventType(eventType);
    }

    @When("^User selects \"(.*)\" event$")
    public void selectEvent(String event){
    }

    @And("^place a \"£0.05\" bet for the \"home\" team to \"Win\"$")
    public void placeBet(String betValue, String team, String result){
        whHomePage.placeBet();
    }

    @And("^assert the odds and returns offered$")
    public void assertOddsAndReturns(){
    }
}
