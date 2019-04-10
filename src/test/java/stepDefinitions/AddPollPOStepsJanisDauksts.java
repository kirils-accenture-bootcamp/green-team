package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.PollQuestionAndAnswersPageJanisDauksts;

public class AddPollPOStepsJanisDauksts {
    private WebDriver driver;
    static PollQuestionAndAnswersPageJanisDauksts jdPage;
    public AddPollPOStepsJanisDauksts() { this.driver = Hooks.driver;
        this.driver = Hooks.driver;
        jdPage = PageFactory.initElements(Hooks.driver, PollQuestionAndAnswersPageJanisDauksts.class); }



    
    
    @When("^I press Add New poll$")
    public void iPressAddNewPoll() throws Throwable {
        
    }

    @And("^Input the (.+) of the poll$")
    public void inputTheNameOfThePoll() throws Throwable {
       
    }

    @And("^I choose template$")
    public void iChooseTemplate() throws Throwable {
        
    }

    @And("^I move to Questions and Answers tab$")
    public void iMoveToQuestionsAndAnswersTab() throws Throwable {
       
    }

    @And("^Enter (.+)$")
    public void enterQuestion() throws Throwable {
        
    }

    @And("^Enter (.+)$")
    public void enterAnswer(int arg0) throws Throwable {
        
    }


    @And("^Enter (.+)$")
    public void enterAnswerB() throws Throwable {

    }

    @And("^Add a new answer$")
    public void addANewAnswer() throws Throwable {

    }

    @And("^Enter (.+)$")
    public void enterAnswerC() throws Throwable {

    }

    @And("^Press Publish button$")
    public void pressPublishButton() throws Throwable {

    }

    @And("^Edit access configurations$")
    public void editAccessConfigurations() throws Throwable {

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

    @Given("^I am on the Wordpress page$")
    public void iAmOnTheWordpressPage() throws Throwable {
        jdPage.iAmOnTheWordpressPage();



    }
}
