package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage_PjotrsL;
import pages.PollPollOptionsPage_PjotrL;

public class LoginAsAdmin_PjotrsL {

    private WebDriver driver;
    static LoginPage_PjotrsL login;
    static PollPollOptionsPage_PjotrL PollOptions;


    public LoginAsAdmin_PjotrsL() {
        this.driver = Hooks.driver;
        login = PageFactory.initElements(Hooks.driver, LoginPage_PjotrsL.class);
        PollOptions = PageFactory.initElements(Hooks.driver, PollPollOptionsPage_PjotrL.class);
    }


    @Given("^I login as administrator$")
    public void iLoginAsAdministrator() throws Throwable {
        driver.get("http://192.168.8.112:81/wordpress/wp-login.php");
        login.LoginAsAdmin();
    }

    @And("^I go to Add poll - Poll Options page$")
    public void iGoToAddPollPollOptions() throws Throwable {
        driver.get(PollOptions.NewPollUrl());
        driver.findElement(By.xpath("//a[@href='#poll-options']")).click();
    }

}
