package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PollPollOptionsPage_PjotrL;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;


public class PollOptionsSteps_PjotrsL {

    private WebDriver driver;
    static PollPollOptionsPage_PjotrL PollOptions;
    private static WebDriverWait wait;
    static long startTime;


    public PollOptionsSteps_PjotrsL() {
        this.driver = Hooks.driver;
        PollOptions = PageFactory.initElements(Hooks.driver, PollPollOptionsPage_PjotrL.class);
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        startTime = System.currentTimeMillis();
    }


    @Then("^I click Poll tab in Poll Options$")
    public void iClickPollTab() throws Throwable {
        driver.findElement(By.xpath("//a[text()='\n\t\t\t\t\t\t\t\t\t\t\t\tPoll\t\t\t\t\t\t\t\t\t\t\t']")).click();
    }

    @And("^I enter values in fields for Vote Button section:$")
    public void VoteButtonSectionValues(Map<String, String> values) throws Throwable {
        //Vote Button area
        PollOptions.inputVoteButtonLabel(values.get("Vote Button Label"));
        PollOptions.ShowResults(values.get("Show [Results] Link"));
        PollOptions.ShowTotalVotes(values.get("Show Total Votes"));
        PollOptions.ShowTotalAnswers(values.get("Show Total Answers"));

        assertEquals(driver.findElement(By.xpath("//input[@class='form-control vote-button-label']")).getAttribute("value"), values.get("Vote Button Label"));
        Select dropShowResults = new Select(driver.findElement(By.className("show-results-link")));
        assertEquals(dropShowResults.getFirstSelectedOption().getText(), values.get("Show [Results] Link"));
        Select dropTotalVotes = new Select(driver.findElement(By.className("show-total-votes")));
        assertEquals(dropTotalVotes.getFirstSelectedOption().getText(), values.get("Show Total Votes"));
        Select dropShowTotalAnswers = new Select(driver.findElement(By.className("show-total-answers")));
        assertEquals(dropShowTotalAnswers.getFirstSelectedOption().getText(), values.get("Show Total Answers"));
    }

    @And("^I enter values in fields for Preferences section:$")
    public void PreferencesSectionValues(Map<String, String> values) throws Throwable {
        PollOptions.StartDate(values.get("Start Date"));
        PollOptions.EndDate(values.get("End Date"));
        PollOptions.RedirectAfterVote(values.get("Redirect after vote option"));
        PollOptions.RedirectAfterVoteUrl(values.get("Redirect after vote Url"));
        PollOptions.ResetPollStatsAutomatically(values.get("Reset Poll Stats automatically"));
        PollOptions.ResetPollStatsAutomaticallyOptions(values.get("Reset every"), values.get("Hours/Days select"));
        PollOptions.AutoGeneratePollPage(values.get("Auto Generate Poll Page"));
        PollOptions.UseCapcha(values.get("Use Captcha"));

        Select dropStartDate = new Select(driver.findElement(By.className("start-date-option")));
        assertEquals(dropStartDate.getFirstSelectedOption().getText(), values.get("Start Date"));
        Select dropEndDate = new Select(driver.findElement(By.className("end-date-option")));
        assertEquals(dropEndDate.getFirstSelectedOption().getText(), values.get("End Date"));
        Select dropRedirectAfterVote = new Select(driver.findElement(By.className("redirect-after-vote")));
        assertEquals(dropRedirectAfterVote.getFirstSelectedOption().getText(), values.get("Redirect after vote option"));
        assertEquals(driver.findElement(By.xpath("//input[@class='form-control redirect-url']")).getAttribute("value"), values.get("Redirect after vote Url"));
        Select dropResetPollStatus = new Select(driver.findElement(By.className("reset-poll-stats-automatically")));
        assertEquals(dropResetPollStatus.getFirstSelectedOption().getText(), values.get("Reset Poll Stats automatically"));
        assertEquals(driver.findElement(By.xpath("//input[@class='form-control reset-poll-stats-every']")).getAttribute("value"), values.get("Reset every"));
        Select dropResetPollStatusHrDay = new Select(driver.findElement(By.xpath("//select[@class='reset-poll-stats-every-period select2-hidden-accessible']")));
        assertEquals(dropResetPollStatusHrDay.getFirstSelectedOption().getText(), values.get("Hours/Days select"));
        Select dropAutoGeneratePollPage = new Select(driver.findElement(By.className("auto-generate-poll-page")));
        assertEquals(dropAutoGeneratePollPage.getFirstSelectedOption().getText(), values.get("Auto Generate Poll Page"));
        Select dropUseCapcha = new Select(driver.findElement(By.className("use-captcha")));
        assertEquals(dropUseCapcha.getFirstSelectedOption().getText(), values.get("Use Captcha"));
    }

    @Then("^I enter values in fields for Notifications section:$")
    public void iEnterValuesInFieldsForNotificationsSection(Map<String, String> values) throws Throwable {
        PollOptions.SendEmailNotifications(values.get("Send Email notifications"));
        PollOptions.SendEmailNotificationsValues(values.get("From Name"), values.get("From Email"), values.get("Recipients"), values.get("Subject"), values.get("Message"));

        Select dropSendNotifications = new Select(driver.findElement(By.className("send-email-notifications")));
        assertEquals(dropSendNotifications.getFirstSelectedOption().getText(), values.get("Send Email notifications"));
        assertEquals(driver.findElement(By.className("email-notifications-from-name")).getAttribute("value"), values.get("From Name"));
        assertEquals(driver.findElement(By.className("email-notifications-from-email")).getAttribute("value"), values.get("From Email"));
        assertEquals(driver.findElement(By.className("email-notifications-recipients")).getAttribute("value"), values.get("Recipients"));
        assertEquals(driver.findElement(By.className("email-notifications-subject")).getAttribute("value"), values.get("Subject"));
        assertEquals(driver.findElement(By.className("email-notifications-message")).getAttribute("value"), values.get("Message"));
    }


    @Then("^I enter values in fields for Compliance section:$")
    public void iEnterValuesInFieldsForComplianceSection(Map<String, String> values) throws Throwable {
        PollOptions.EnableGDPR(values.get("Enable GDPR"));
        PollOptions.GDPRSolution(values.get("Solution"), values.get("Text for consent checkbox"));

        Select dropEnableGDPR = new Select(driver.findElement(By.className("enable-gdpr")));
        assertEquals(dropEnableGDPR.getFirstSelectedOption().getText(), values.get("Enable GDPR"));
        Select dropGDPRSolution = new Select(driver.findElement(By.className("gdpr-solution")));
        assertEquals(dropGDPRSolution.getFirstSelectedOption().getText(), values.get("Solution"));
        assertEquals(driver.findElement(By.className("gdpr-consent-text")).getAttribute("value"), values.get("Text for consent checkbox"));
    }

    @Then("^I select Start Date from calendar$")
    public void iSelectStartDateFromCalendar() throws Throwable {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='form-horizontal poll-preferences']")));
        actions.perform();
        PollOptions.ClickCalendarIcon();
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//a[@data-handler='next']")).click();
        driver.findElement(By.xpath("//td[@data-month='4' and @data-year='2019']/a[text()='1']")).click();
        Select dropdownHr = new Select(driver.findElement(By.xpath("//select[@data-unit='hour']")));
        dropdownHr.selectByValue("11");
        Select dropdownMin = new Select(driver.findElement(By.xpath("//select[@data-unit='minute']")));
        dropdownMin.selectByValue("47");
        driver.findElement(By.xpath("//button[@data-handler='hide']")).click();

        assertEquals("2019-05-01 11:47", driver.findElement(By.xpath("//input[@class='form-control start-date-custom-hidden hasDatepicker']")).getAttribute("value"));
    }

}
