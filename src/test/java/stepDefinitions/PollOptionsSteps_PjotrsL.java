package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.PollPollOptionsPage;

public class PollOptionsSteps_PjotrsL {

    private WebDriver driver;
    static PollPollOptionsPage PollOptions;


    public PollOptionsSteps_PjotrsL() {
        this.driver = Hooks.driver;
        PollOptions = PageFactory.initElements(Hooks.driver, PollPollOptionsPage.class);
    }

    @And("^I go to Add poll - Poll Options page$")
    public void iGoToAddPollPollOptions() throws Throwable{
        driver.get(PollOptions.PollOptionsUrl());
        driver.findElement(By.xpath("//a[@href='#poll-options']")).click();
    }

    @Then("^I click Poll tab$")
    public void iClickPollTab() throws Throwable {
        driver.findElement(By.xpath("//a[text()='Poll']")).click();
    }
}
