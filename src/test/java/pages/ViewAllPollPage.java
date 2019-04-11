package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stepDefinitions.Hooks;

import java.util.List;


public class ViewAllPollPage {


    @FindBy(how = How.XPATH, using = "//i[@class='fa fa-code']")
    private List<WebElement> codeList;

    @FindBy(how = How.XPATH, using = "//a[@class='get-poll-code' and @data-id='5']")
    private WebElement mycode;

    @FindBy(how = How.XPATH, using = "//i[@class='fa fa-code']")
    private WebElement firstCodeElement;

    @FindBy(how = How.CSS, using = "#copy-yop-poll-code")
    private WebElement buttonCopyToClipBoard;

    @FindBy(how = How.CSS, using = "#copy-yop-poll-code")
    private WebElement shortCode;

    @FindBy(how = How.XPATH, using = "//li[@class='wp-has-submenu wp-has-current-submenu wp-menu-open menu-top menu-icon-page']")
    private WebElement pagesMenu;

    @FindBy(how = How.CSS, using = "//li[@class='current']")
    private WebElement addNewPage;

    public void preessCopyToClipBoard() throws Throwable {
        buttonCopyToClipBoard.click();


    }

    public WebElement findShortcodeByIndex(int index){
        return codeList.get(index);
    }

    public void getShortcode() throws Throwable {
        firstCodeElement.click();


    }
    public void preessAddNewPage() throws Throwable {
        pagesMenu.click();
        addNewPage.click();

    }
}