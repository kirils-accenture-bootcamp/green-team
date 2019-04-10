package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PollPage {
    @FindBy(how = How.ID, using = "")
    private WebElement publishBtn;

    @FindBy(how = How.ID, using = "")
    private WebElement tabDesign;

    @FindBy(how = How.ID, using = "")
    private WebElement tabQaA;

    @FindBy(how = How.ID, using = "")
    private WebElement tabOther;

    @FindBy(how = How.ID, using = "")
    private WebElement allPollsBtn;

    // TODO set status

    public void clickPublishBtn(){
        publishBtn.click();
    }

    public void clickDesignTab(){
        tabDesign.click();
    }

    public void clickAllPollsBtn(){
        allPollsBtn.click();
    }
}
