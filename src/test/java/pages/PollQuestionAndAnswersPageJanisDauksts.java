package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class PollQuestionAndAnswersPageJanisDauksts {


@FindBy (how = How.CSS, using = ".page-title-action")
    private WebElement AddNewPoll;


@FindBy (how = How.XPATH, using = "//*[@id=\"toplevel_page_yop-polls\"]")
private WebElement openAllPollPage;

@FindBy (how = How.XPATH, using = "//*[@id=\"title\"]")
    private WebElement pollTitle ;

    @FindBy (how = How.XPATH, using = "//*[@id=\"templates-carousel\"]/a[2]/span[1]")
    private WebElement goToRIghtTemplate ;

    @FindBy (how = How.XPATH, using = "//*[@id=\"templates-carousel\"]/a[1]/span[1]")
    private WebElement goToLeftTemplate ;

    @FindBy (how = How.XPATH, using = "//*[@id=\"publish\"]")
    private WebElement useCustomizeButton;

    @FindBy (how = How.XPATH, using = "//*[@id=\"poll-design\"]/div[1]/div[1]/a")
    private WebElement chooseATemplateButton;

    @FindBy (how = How.XPATH, using = "//*[@id=\"poll-design\"]/div[1]/div[2]/a")
    private WebElement stylesButton;

    @FindBy (how = How.XPATH, using = "//*[@id=\"yop-poll-form\"]/div/div[2]/div/ul/li[2]/a")
    private WebElement questionAndAnswerTab;


@FindBy (how = How.XPATH, using = "//*[@id=\"yopPollUpgradeModal\"]/div/div/div[1]/button")
private WebElement closeAD;

    @FindBy (how = How.XPATH, using = "//*[@id=\"toplevel_page_yop-polls\"]/a/div[3]")
    private WebElement PollsMenuButton;




    @FindBy (how = How.XPATH, using = "//*[@id=\"poll-questions\"]/div[2]/div/div[4]/div/div/div/div[2]/div[1]/div/input")
    private WebElement enterNewQuestion ;

   @FindBy (how = How.XPATH, using = "")
    private WebElement answerA ;

    @FindBy (how = How.XPATH, using = "")
    private WebElement answerB ;

@FindBy (how = How.XPATH, using ="//*[@id=\"publish-poll\"]")
private WebElement publishPoll;


@FindBy (how = How.XPATH, using = "//*[@id=\"yop-poll-form\"]/div/div[2]/div/ul/li[3]/a")
private WebElement optionsButton;

@FindBy (how =How.XPATH, using = "//*[@id=\"poll-questions\"]/div[2]/div/div[4]/div/div/div/div[1]/span[2]/a[1]/span[1]")
private WebElement addNewAnswer;






    public void addNewPoll() throws Exception{
        AddNewPoll.click();
    }


    public void enterPollTitle (String name) throws Exception {
        pollTitle.clear();
        pollTitle.sendKeys(name);

    }

    public void openAllPolls (){
        openAllPollPage.click();
    }

    public void chooseTemplate () throws InterruptedException {
        goToRIghtTemplate.click();
        TimeUnit.MILLISECONDS.sleep(500);
        goToLeftTemplate.click();
        TimeUnit.MILLISECONDS.sleep(500);
        useCustomizeButton.click();


    }

    public void moveToQnAPage () throws InterruptedException {
        questionAndAnswerTab.click();
        Thread.sleep(1000);
    }

    public void enterYourQuestion (String question) throws Exception {

        enterNewQuestion.clear();
        enterNewQuestion.sendKeys(question);
        Thread.sleep(2000);
    }


    public void enterAnswerA (String answeraa) throws Exception {
        answerA.clear();
        answerA.sendKeys(answeraa);

    }

    public void enterAnswerB (String answerbb) throws Exception{
        answerB.clear();
        answerB.sendKeys(answerbb);
    }


    public void optButton () throws Exception{
        optionsButton.click();
    }

    public void publishPoll () throws Exception {
        publishPoll.click();
        TimeUnit.MILLISECONDS.sleep(5000);
    }

    public void addAnswer (String newAnswer) throws Exception {
        addNewAnswer.click();
    }










}
