package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PollQuestionAndAnswersPageJanisDauksts {


@FindBy (how = How.XPATH, using = "//*[@id=\"yop-main-area\"]/h1/a")
    private WebElement AddNewPoll;

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




    @FindBy (how = How.XPATH, using = "//*[@id=\"toplevel_page_yop-polls\"]/a/div[3]")
    private WebElement PollsMenuButton;





    public void iAmOnTheWordpressPage() throws Exception {
        PollsMenuButton.click();
    }















}
