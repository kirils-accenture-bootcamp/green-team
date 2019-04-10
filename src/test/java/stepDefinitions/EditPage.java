package stepDefinitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.EditPagePage;

public class EditPage {
    private WebDriver driver;
    static EditPagePage editPagePage;




    @Given("^I am on page$")
    public void iAmOnPage() throws Throwable {
        driver.get("http://192.168.8.112:81/wordpress/wp-admin/");
    }
}
