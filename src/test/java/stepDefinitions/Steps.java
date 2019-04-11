package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class Steps {
    private WebDriver driver;
    static EditPage editPage;
    static ViewAllPollPage viewAllPollPage;
    static LoginPage loginPage;
    static AddNewPoll addNewPoll;
    static AllPagesPage allPagesPage;

    private static WebDriverWait wait;


    public Steps() {
        this.driver = Hooks.driver;

        editPage = PageFactory.initElements(Hooks.driver, EditPage.class);
        viewAllPollPage = PageFactory.initElements(Hooks.driver, ViewAllPollPage.class);
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
        addNewPoll = PageFactory.initElements(Hooks.driver, AddNewPoll.class);
        allPagesPage = PageFactory.initElements(Hooks.driver, AllPagesPage.class);
    }


    @Given("^I am on page$")
    public void iAmOnPage() throws Throwable {
        driver.get("http://192.168.8.112:81/wordpress/wp-admin/");
    }

    @And("^I get the poll code from shortcode field$")
    public void iGetThePollCodeFromShortcodeField() throws Throwable {
        viewAllPollPage.getShortcode();
        Thread.sleep(10000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#copy-yop-poll-code")));
        viewAllPollPage.preessCopyToClipBoard();


    }

    @And("^I put shortcode in New page$")
    public void iPutShortcodeInNewPage() throws Throwable {
        //WebDriverWait wait=new WebDriverWait(driver,5);
        Thread.sleep(5000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#copy-yop-poll-code")));
        driver.get("http://192.168.8.112:81/wordpress/wp-admin/post-new.php?post_type=page");
        editPage.enterNewPageTitle("Svetlana's page");
        editPage.pasteShortcode();


    }

    @And("^I Publish the page$")
    public void iPublishThePage() throws Throwable {
        Thread.sleep(10000);
        editPage.pressPublish();
        // editPage.pressViewPage();
    }

    @Then("^The Poll is published to page$")
    public void thePollIsPublishedToPage() {
        editPage.pressPermalink();

    }


    @Given("^Login as admin$")
    public void loginAsAdmin() {
        driver.get("http://192.168.8.112:81/wordpress/wp-login.php?loggedout=true");
        loginPage.LoginAsAdmin();
    }

    @When("^I am on View all poll page$")
    public void iAmOnViewAllPollPage() throws Throwable {
        driver.get("http://192.168.8.112:81/wordpress/wp-admin/admin.php?page=yop-polls");
    }

    @And("^I put shortcode in Existing page$")
    public void iPutShortcodeInExistingPage() throws Throwable {
        //WebDriverWait wait=new WebDriverWait(driver,5);
        Thread.sleep(5000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#copy-yop-poll-code")));
        driver.get("http://192.168.8.112:81/wordpress/wp-admin/edit.php?post_type=page");
        Thread.sleep(5000);

        allPagesPage.clickOnExistingPage();

        editPage.pasteShortcode();
    }

    @When("^i am on add poll page$")
    public void iAmOnAddPollPage() throws Throwable {
        driver.get("http://192.168.8.112:81/wordpress/wp-admin/admin.php?page=yop-poll-add-poll");


    }

    @And("^i <name> the poll$")
    public void iNameThePoll(String name) throws Throwable {
        addNewPoll.inputName(name);


    }

    @And("^i choose the poll Template$")
    public void iChooseThePollTemplate() throws Throwable {

    }


    @And("^I am on Add new page page$")
    public void iAmOnAddNewPagePage() throws Throwable {
        driver.get("http://192.168.8.112:81/wordpress/wp-admin/post-new.php?post_type=page");
    }

    @And("^I clict to Add new page$")
    public void iClictToAddNewPage() throws Throwable {
        viewAllPollPage.preessAddNewPage();

    }

    @And("^i enter the poll\"([^\"]*)\"$")
    public void iEnterThePoll(String name) throws Throwable {
        addNewPoll.inputName(name);

    }

    @And("^i enter poll question \"([^\"]*)\"$")
    public void iEnterPollQuestion(String question) throws Throwable {
        addNewPoll.goToQuestionsAndAnswersTab();
        Thread.sleep(5000);
        addNewPoll.inputQuestion(question);
    }

    @And("^i choose a template$")
    public void iChooseATemplate() throws Throwable {
        addNewPoll.chooseBasicTamplate();
    }

    @And("^i choose poll options$")
    public void iChoosePollOptions() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='#poll-options']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(.,'Access')]")).click();
        driver.findElement(By.xpath("//.content-options-access .form-group:nth-child(1) .select2-search__field")).sendKeys("Guest"+ Keys.ENTER);


    }
}