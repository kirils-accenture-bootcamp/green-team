package stepDefinitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage_PjotrsL;
import pages.PollPollOptionsPage;

public class LoginAsAdmin_PjotrsL {

    private WebDriver driver;
    static LoginPage_PjotrsL login;


    public LoginAsAdmin_PjotrsL() {
        this.driver = Hooks.driver;
        login = PageFactory.initElements(Hooks.driver, LoginPage_PjotrsL.class);
    }


    @Given("^I login as administrator$")
    public void iLoginAsAdministrator() throws Throwable {
        driver.get("http://192.168.8.112:81/wordpress/wp-login.php");
        login.LoginAsAdmin();
    }
}
