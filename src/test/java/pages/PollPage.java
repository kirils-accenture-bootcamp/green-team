package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PollPage {
    @FindBy(how = How.CSS, using = "#publish-poll")
    private WebElement publishBtn;

    @FindBy(how = How.XPATH, using = "//a[contains(., 'Design')]")
    private WebElement tabDesign;

    @FindBy(how = How.XPATH, using = "//a[contains(., 'Question & Answers')]")
    private WebElement tabQaA;

    @FindBy(how = How.XPATH, using = "//a[contains(., 'Options')]")
    private WebElement tabOptions;

    @FindBy(how = How.XPATH, using = "//a[.='All Polls']")
    private WebElement allPollsBtn;

    @FindBy(how = How.XPATH, using = "//div[.='Pages']")
    private WebElement pagesMenu;

    public void clickPublishBtn(){
        publishBtn.click();
    }

    public void clickDesignTab(){
        tabDesign.click();
    }

    public void clickQaATab(){
        tabQaA.click();
    }

    public void clickOptionsTab(){
        tabOptions.click();
    }

    public void clickAllPollsBtn(){
        allPollsBtn.click();
    }

    public void clickPagesMenu(){
        pagesMenu.click();
    }
}
