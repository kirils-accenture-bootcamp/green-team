package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PollPollOptionsPage_PjotrL {

    //New Poll > Options > Poll tab
    //Vote Button section
    @FindBy(how = How.XPATH, using = "//input[@class='form-control vote-button-label']")
    private WebElement inputVoteButtonLabel;
    @FindBy(how = How.CLASS_NAME, using = "show-results-link")
    private WebElement dropShowResults;
    @FindBy(how = How.CLASS_NAME, using = "show-total-votes")
    private WebElement dropShowTotalVotes;
    @FindBy(how = How.CLASS_NAME, using = "show-total-answers")
    private WebElement dropShowTotalAnswers;
    //Preferences section
    @FindBy(how = How.CLASS_NAME, using = "start-date-option")
    private WebElement dropStartDate;
    @FindBy(how = How.XPATH, using = "//i[@class='fa fa-calendar show-start-date']")
    private WebElement clickCalendarIcon;
    @FindBy(how = How.CLASS_NAME, using = "end-date-option")
    private WebElement dropEndDate;
    @FindBy(how = How.CLASS_NAME, using = "redirect-after-vote")
    private WebElement dropRedirectAfterVote;
    @FindBy(how = How.XPATH, using = "//input[@class='form-control redirect-url']")
    private WebElement inputRedirectUrl;
    @FindBy(how = How.CLASS_NAME, using = "reset-poll-stats-automatically")
    private WebElement dropResetPollStatsAutomatically;
    @FindBy(how = How.XPATH, using = "//input[@class='form-control reset-poll-stats-every']")
    private WebElement inputResetPollStatsEvery;
    @FindBy(how = How.XPATH, using = "//select[@class='reset-poll-stats-every-period select2-hidden-accessible']")
    private WebElement dropResetHoursDays;
    @FindBy(how = How.CLASS_NAME, using = "auto-generate-poll-page")
    private WebElement dropAutoGeneratePollPage;
    @FindBy(how = How.CLASS_NAME, using = "use-captcha")
    private WebElement dropUseCaptcha;
    //Notifications section
    @FindBy(how = How.CLASS_NAME, using = "send-email-notifications")
    private WebElement dropSendEmailNotifications;
    @FindBy(how = How.CLASS_NAME, using = "email-notifications-from-name")
    private WebElement inputFromName;
    @FindBy(how = How.CLASS_NAME, using = "email-notifications-from-email")
    private WebElement inputFromEmail;
    @FindBy(how = How.CLASS_NAME, using = "email-notifications-recipients")
    private WebElement inputRecipients;
    @FindBy(how = How.CLASS_NAME, using = "email-notifications-subject")
    private WebElement inputSubjectText;
    @FindBy(how = How.CLASS_NAME, using = "email-notifications-message")
    private WebElement inputMessageText;
    //Compliance section
    @FindBy(how = How.CLASS_NAME, using = "enable-gdpr")
    private WebElement dropEnableGDPR;
    @FindBy(how = How.CLASS_NAME, using = "gdpr-solution")
    private WebElement dropGDPRSolution;
    @FindBy(how = How.CLASS_NAME, using = "gdpr-consent-text")
    private WebElement inputGDPRSolution;


    public String NewPollUrl() {
        return "http://192.168.8.112:81/wordpress/wp-admin/admin.php?page=yop-poll-add-poll";
    }

    public void inputVoteButtonLabel(String inputVBL) {
        inputVoteButtonLabel.clear();
        inputVoteButtonLabel.sendKeys(inputVBL);
    }

    public void ShowResults(String option) {
        Select dropdown = new Select(dropShowResults);
        dropdown.selectByVisibleText(option);
    }

    public void ShowTotalVotes(String option) {
        Select dropdown = new Select(dropShowTotalVotes);
        dropdown.selectByVisibleText(option);
    }

    public void ShowTotalAnswers(String option) {
        Select dropdown = new Select(dropShowTotalAnswers);
        dropdown.selectByVisibleText(option);
    }

    public void StartDate(String option) {
        Select dropdown = new Select(dropStartDate);
        dropdown.selectByVisibleText(option);
    }

    public void EndDate(String option) {
        Select dropdown = new Select(dropEndDate);
        dropdown.selectByVisibleText(option);
    }

    public void RedirectAfterVote(String option) {
        Select dropdown = new Select(dropRedirectAfterVote);
        dropdown.selectByVisibleText(option);
    }

    public void RedirectAfterVoteUrl(String url) {
        inputRedirectUrl.clear();
        inputRedirectUrl.sendKeys(url);
    }

    public void ResetPollStatsAutomatically(String option) {
        Select dropdown = new Select(dropResetPollStatsAutomatically);
        dropdown.selectByVisibleText(option);
    }

    public void ResetPollStatsAutomaticallyOptions(String resetEveryAmount, String hrsDays) {
        inputResetPollStatsEvery.clear();
        inputResetPollStatsEvery.sendKeys(resetEveryAmount);
        Select dropdown = new Select(dropResetHoursDays);
        dropdown.selectByVisibleText(hrsDays);
    }

    public void AutoGeneratePollPage(String option) {
        Select dropdown = new Select(dropAutoGeneratePollPage);
        dropdown.selectByVisibleText(option);
    }

    public void UseCapcha(String option) {
        Select dropdown = new Select(dropUseCaptcha);
        dropdown.selectByVisibleText(option);
    }

    public void SendEmailNotifications(String option) {
        Select dropdown = new Select(dropSendEmailNotifications);
        dropdown.selectByVisibleText(option);
    }

    public void SendEmailNotificationsValues(String fromName, String fromEmail, String recipients, String subjectText, String messageText) {
        inputFromName.clear();
        inputFromName.sendKeys(fromName);
        inputFromEmail.clear();
        inputFromEmail.sendKeys(fromEmail);
        inputRecipients.clear();
        inputRecipients.sendKeys(recipients);
        inputSubjectText.clear();
        inputSubjectText.sendKeys(subjectText);
        inputMessageText.clear();
        inputMessageText.sendKeys(messageText);
    }

    public void EnableGDPR(String option){
        Select dropdown = new Select(dropEnableGDPR);
        dropdown.selectByVisibleText(option);
    }

    public void GDPRSolution(String option, String message){
        Select dropdown = new Select(dropGDPRSolution);
        dropdown.selectByVisibleText(option);
        inputGDPRSolution.clear();
        inputGDPRSolution.sendKeys(message);
    }

    public void ClickCalendarIcon(){
        clickCalendarIcon.click();
    }
}
