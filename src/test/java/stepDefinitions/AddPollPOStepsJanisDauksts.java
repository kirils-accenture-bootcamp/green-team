package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage_PjotrsL;
import pages.PollQuestionAndAnswersPageJanisDauksts;

import java.util.concurrent.TimeUnit;

public class AddPollPOStepsJanisDauksts {
    private WebDriver driver;
    private static WebDriverWait wait;
    static PollQuestionAndAnswersPageJanisDauksts jdPage;
    static LoginPage_PjotrsL logInPage;

    public AddPollPOStepsJanisDauksts() { this.driver = Hooks.driver;
        this.driver = Hooks.driver;
        jdPage = PageFactory.initElements(Hooks.driver, PollQuestionAndAnswersPageJanisDauksts.class);
        logInPage = PageFactory.initElements(Hooks.driver, LoginPage_PjotrsL.class);
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
    }



    
    
    @And("^I press Add New poll$")
    public void iPressAddNewPoll() throws Throwable {
        jdPage.addNewPoll();
    }

    @And("^Input the (.+) of the poll$")
    public void inputTheNameOfThePoll(String name) throws Throwable {
       jdPage.enterPollTitle(name);
    }

    @And("^I choose template$")
    public void iChooseTemplate() throws Throwable {
        jdPage.chooseTemplate();

    }

    @And("^I move to Questions and Answers tab$")
    public void iMoveToQuestionsAndAnswersTab() throws Throwable {

        jdPage.moveToQnAPage();
Thread.sleep(500);
    }





    @And("^Add a new answer$")
    public void addANewAnswer(String answerC) throws Throwable {
jdPage.addAnswer(answerC);
Thread.sleep(2000);
    }





    @And("^Edit access configurations$")
    public void editAccessConfigurations() throws Throwable {
jdPage.optButton();
Thread.sleep(500);
    }

    @And("^Publish poll$")
    public void publishPoll() throws Throwable {

    }

    @And("^I am redirected to All poll page$")
    public void iAmRedirectedToAllPollPage() throws Throwable {

    }

    @And("^I open the poll I have made$")
    public void iOpenThePollIHaveMade() throws Throwable {

    }

    @Then("^I check saved inputs$")
    public void iCheckSavedInputs() throws Throwable {

    }



    @Given("^I am on the All Poll page$")
    public void iAmOnTheAllPollPage() throws Throwable {
        driver.get("http://192.168.8.112:81/wordpress/wp-admin/admin.php?page=yop-polls");

    }

    @And("^I Enter question (.+)$")
    public void iEnterQuestionQuestion(String question) throws Throwable {
        jdPage.enterYourQuestion(question);
        Thread.sleep(2000);
    }

    @And("^I Enter answerA (.+)$")
    public void iEnterAnswerAAnswerA(String answerA) throws Throwable {
        jdPage.enterAnswerA(answerA);
    }

    @And("^I Enter answerB (.+)$")
    public void iEnterAnswerBAnswerB(String answerB) throws Throwable {
       jdPage.enterAnswerB(answerB);
    }

    @And("^I Enter answerC (.+)$")
    public void iEnterAnswerCAnswerC() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I log in as gt$")
    public void iLogInAsGt() throws Throwable {
        logInPage.LoginAsAdmin();
    }

    @Given("^Web page is opened$")
    public void webPageIsOpened() throws Throwable {
        driver.get("http://192.168.8.112:81/wordpress/wp-login.php");
    }

    @And("^Open All poll page$")
    public void openAllPollPage() throws Throwable {
        jdPage.openAllPolls();

    }
}
