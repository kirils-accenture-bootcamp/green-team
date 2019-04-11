package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AddNewPoll {


    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Yop Poll')]")
    private WebElement yopPollMenu;
    @FindBy(how = How.CSS, using = "#publish-poll")
    private WebElement buttonPublishPoll;


    @FindBy(how = How.CSS, using = "#publish")
    private WebElement useAndCustumize;

    @FindBy(how = How.XPATH, using = "//input[@name='poll[name]']")
    private WebElement pollNameInput;

    @FindBy(how = How.XPATH, using = "//a[@href='#poll-questions']")
    private WebElement questionsAndAnswerTab;

    @FindBy(how = How.XPATH, using = "//*[@id=\"poll-questions\"]/div[2]/div/div[4]/div/div/div/div[2]/div[1]/div/input")
    private WebElement questionInput;

    @FindBy(how = How.XPATH, using = "//input[@class='form-control input-lg question-value']")
    private List<WebElement> questionAndAnswerList;


    public void inputName(String name) {
        pollNameInput.clear();
        pollNameInput.sendKeys(name);
    }

    public void clickOnYopPoll() {
        yopPollMenu.click();
    }
    public void chooseBasicTamplate() throws Throwable {
        useAndCustumize.click();

    }


    public void goToQuestionsAndAnswersTab() throws Throwable {
        questionsAndAnswerTab.click();

    }

    public void inputQuestion(String question) throws Throwable {
        questionInput.clear();
        questionInput.sendKeys(question);
    }


//a[@href='#poll-options']
}
